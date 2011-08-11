package examples;

/* Read here to understand this class. 
 * The following definitions are examples of tagged type asn1 definitions :
    
    ---- with EXPLICIT method and CONTEXT class tagging
    TaggedTypeExample   ::= [20] EXPLICIT   INTEGER   			
    ----- Another example with IMPLICIT method and APPLICATION class tagging:
    TaggedTypeExample_2 ::= [APPLICATION 20] INTEGER
    
    Let's consider the TaggedTypeExample asn1 element. JAC does not create java classes of tagged types. 
    But you can do it with a little trick. Just delete the words before asn1 type name (before "INTEGER" in this example) 
    So the new format will be:
    
    TaggedTypeExample   ::= INTEGER  
    
    Then start JAC and go to the created class "TaggedTypeExample.java". 
    And add the following lines in all the constructors:
    
    this.setTagClass(Tag.CONTEXT);			
	this.setTagNumber(20);					
	this.setTaggingMethod(Tag.EXPLICIT);	
	
	JUST LIKE IN THE CONSTRUCTORS OF THIS CLASS BELOW:)
    
 * 
 * */

import com.chaosinmotion.asn1.Tag;
import com.turkcelltech.jac.ASN1Integer;

public class TaggedTypeExample extends ASN1Integer
{

	public
	TaggedTypeExample()
	{
		super();
		this.setTagClass(Tag.CONTEXT);			//should be added by user by hand in all constructors after generation of the class.
		this.setTagNumber(20);					//should be added by user by hand in all constructors after generation of the class.
		this.setTaggingMethod(Tag.EXPLICIT);	//should be added by user by hand in all constructors after generation of the class.
	}

	public
	TaggedTypeExample(String name)
	{
		super(name);
		this.setTagClass(Tag.CONTEXT);			//should be added by user by hand in all constructors after generation of the class.
		this.setTagNumber(20);					//should be added by user by hand in all constructors after generation of the class.
		this.setTaggingMethod(Tag.EXPLICIT);	//should be added by user by hand in all constructors after generation of the class.
	}
	
	/**
	* This constructor added by Fatih Batuk
	*/
	public
	TaggedTypeExample(long value)
	{
		super(value);
		this.setTagClass(Tag.CONTEXT);			//should be added by user by hand in all constructors after generation of the class.
		this.setTagNumber(20);					//should be added by user by hand in all constructors after generation of the class.
		this.setTaggingMethod(Tag.EXPLICIT);	//should be added by user by hand in all constructors after generation of the class.
	
	}
	
	/**
	* This constructor added by Fatih Batuk
	*/
	public
	TaggedTypeExample(String name, long value)
	{
		super(name, value);
		this.setTagClass(Tag.CONTEXT);			//should be added by user by hand in all constructors after generation of the class.
		this.setTagNumber(20);					//should be added by user by hand in all constructors after generation of the class.
		this.setTaggingMethod(Tag.EXPLICIT);	//should be added by user by hand in all constructors after generation of the class.
	
	}
}
