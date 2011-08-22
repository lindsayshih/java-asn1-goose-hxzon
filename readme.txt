About ASN.1:
-----------

The ASN.1 library provides various primitives for reading and writing an ASN.1 data 
stream using BER, CER and DER encoding and decoding. This standard library uses a 
simple state machine mechanism in a hand-rolled parser to parse incoming BER, CER 
and DER data and can be used to build more complex custom parsers to handle protocols 
such as LDAP and SNMP.

This Java library allows you to create an ASN.1 object, a state-driven parser which 
handles incoming messages through building a recursive descent parser which easily 
maps from an ASN.1 specification to code constructed by hand.


To Compile
----------

Both an Eclipse and an ANT build project are provided. You should be able to import this
project directly into Eclipse.

Ant build targets generally define a default build target (generally 'dist') to build
the target .jar file or project distribution, as well as the JavaDocs and a .zip file
with the sources, and a 'clean' target to clean up the build products. Builds generally
are built into a 'ship' folder for distribution. 

Cross-project relationships are generally handled in the build.xml file by assuming that
all project directories are contained in the same top-level directory. So if this
project depends on a 'common' project, you would structure your top level directory
as:

  Development/
     Common/
        src/
        test/
        build.xml
     UITools
        src/
        test/
        build.xml

Each project that relies upon another knows how to trigger ant in the dependent build
directory. So building UITools would automatically trigger a build of Common.


License
-------

Copyright 2007 William Woody, All Rights Reserved.

Redistribution and use in source and binary forms, with or without modification, are 
permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of 
conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list 
of conditions and the following disclaimer in the documentation and/or other materials 
provided with the distribution.

3. Neither the name of Chaos In Motion nor the names of its contributors may be used 
to endorse or promote products derived from this software without specific prior 
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES 
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR 
BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH 
DAMAGE.

Contact William Woody at woody@alumni.caltech.edu or at woody@chaosinmotion.com. 
Chaos In Motion is at http://www.chaosinmotion.com
