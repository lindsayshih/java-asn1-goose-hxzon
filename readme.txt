java-asn1-goose库设计概要
by hxzon
一，整体代码结构
整个库可分为三个部分，如下表：
|-----------------------------------------------------------------------------
| asn1.core包及子包                             | asn.1的基本类型及解码
|------------------------------------------------------------------------------
| asn1.goose,asn1.smv,asn1.mms,asn1.acse        | goose,sv,mms三种报文的asn.1部分解码
|------------------------------------------------------------------------------
| protocol子包                                  | tcp/ip常用报文解析	
|------------------------------------------------------------------------------
二，asn.1解析
1，	asn1.core
asn1.core修改自一个开源的asn.1解码库，该库的官方地址在http://www.chaosinmotion.com/wiki/index.php?title=ASN.1_Library，以下称为原始库。原始库经修改后放在asn1.core下的parse,type,type.base三个子包中，本库扩展部分则放在asn1.core的parse.ext和type.ext子包中。
asn1.core的5个子包如下：
|----------------------------------------------------------------------------------------
|type.base	    | asn.1类型中的基类，包括BerNode，BerConstruct，BerAbstractString
|-----------------------------------------------------------------------------------------
|type	        | asn.1的基本类型
|-----------------------------------------------------------------------------------------
|type.ext	    | BerChoice（原始包没有完成对asn.1选择体的解码），
|               | BitStringPresentation（表示位串），
|               | 
|----------------------------------------------------------------------------------------
|parse	        | asn.1解码，最重要的类是BerInputStream
|----------------------------------------------------------------------------------------
|parse.ext	    | 工具类Asn1Utils
|---------------------------------------------------------------------------------------

2，
原始库以BerParser. readPacket(BerInputStream stream)为入口开始解码asn.1二进制流，通过继承BerParser并实现create(int tag, BerInputStream stream, int state)方法把二进制流解码为一系列BerNode对象，每个BerNode对象表示一个asn.1结构。
原始库的BerParser.create(int tag, BerInputStream stream, int state)是最重要的方法，其中用state来区分不同的解码上下文（所在结构体），使得子类实现create方法过于复杂，所以本库移除了state参数，让每个结构体自己根据tag创建BerNode对象（通过继承实现BerConstruct的create方法）。

3，
其它主要被修改的类是asn1.core.type.base.BerNode和asn1.core.parse.BerInputStream，主要是为了获得offset和len信息。BerNode的tagOffset,lenOffset,valueOffset分别记录一个asn.1结构的标签部分，长度指示部分，值部分在整个二进制流中的位置，而通过它们之间的差值及totalLen可以得到每个部分的长度。

4，asn1.goose,asn1.smv,asn1.mms
这几个包是在asn1.core的基础上对IEC61850所涉及的报文的专门解析。
其中mms定义的数据类型比较多，所以按照基本类型，又分为common,sequence,choice等几个子包。

三，tcp/ip常用报文解析
protocol分为6个包，如下表所示：
|---------------------------------------------
| protocol.common          |接口及辅助类
|---------------------------------------------
| protocol.field           |报文头部的字段
|---------------------------------------------
| protocol.packet          |报文类型
|---------------------------------------------
| protocol.parse           |报文解析
|---------------------------------------------
| protocol.payload         |报文的特殊负载
|----------------------------------------------
| protocol.ui              |UI部分
|----------------------------------------------

1，
protocol.common.IPacketPayload和protocol.common.IPacket是主要的两个接口，IPacketPayload定义了报文负载的特征信息，如底层报文信息，自身长度，在整个报文二进制中的偏移量。IPacket继承了IPacketPayload，因为报文也可以作为另外一种报文的负载，IPacket添加了报文的特征信息，如头部长度，头部字段，负载信息。
protocol.common.PayloadHelper和protocol.common.PacketHelper作为辅助类分别实现上述两个接口。

2，
protocol.packet.Packet继承自PacketHelper,是protocol.packet下所有报文类型的父类。
Packet的expectHeaderFields()方法留给子类创建它们的头部字段。
Packet的私有方法parsePayload()定义了整个负载的解析流程，其中调用了exceptPayload()和findBinding()方法。

exceptPayload()用于让子类根据自身特殊情况定义它的负载，如Ip4Packet和CotpPacket用于处理它们的负载为分片时的情况。
findBinding()从ProtocolBindingList中查找合适的报文负载。protocol.packet下的报文类型，会在静态初始化方法中，向ProtocolBindingList注册自己可能作为哪些报文的负载，以及如何判定负载为自身类型。如Ip4Packet在静态初始化方法中，注册自己可能作为EthernetPacket和VlanPacket的负载，判定方法是这两种报文的头部的type字段值为0x0800时。

3，
protocol.parse包下的Ip4PacketGroup，Ip4PacketCache，CotpPacketGroup，CotpPacketCache用于处理ip4和cotp负载分片的情况。
