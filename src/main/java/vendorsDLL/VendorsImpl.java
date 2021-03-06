package vendorsDLL;

import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import java.sql.Date;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import vendorsModel.Attachment;
import vendorsModel.AttachmentType;
import vendorsModel.Bank;
import vendorsModel.VendorBranches;
import vendorsModel.ContactPerson;
import vendorsModel.Menu;
import vendorsModel.User;
import vendorsModel.Vendor;
import vendorsModel.VendorProduct;

import vendorsModel.VendorType;

public class VendorsImpl implements VendorDAO {
	
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	  public Long AddVendor(Vendor vendor) {
	    	
	    	try {
	    		
	    		SimpleJdbcCall jdbcCall = new 
	                SimpleJdbcCall(dataSource).withProcedureName("AddUpdateVendor")
	                .withoutProcedureColumnMetaDataAccess().declareParameters(
	                		new SqlParameter( "vendorID_in", Types.BIGINT ),
	                		new SqlParameter( "userID_in", Types.BIGINT ),
	                		new SqlParameter( "vendorNameEn_in", Types.VARCHAR ),
	                		new SqlParameter( "vendorNameAr_in", Types.VARCHAR ),
	                		new SqlParameter( "vendorTypeID_in", Types.INTEGER ),
	                		new SqlParameter( "email_in", Types.VARCHAR ),
	                		new SqlParameter( "lanNumber_in", Types.VARCHAR ),
	                		new SqlParameter( "mobileNumber_in", Types.VARCHAR ),
	                		new SqlParameter( "webSiteurl_in", Types.VARCHAR ),
	                		new SqlParameter( "crNumber_in", Types.VARCHAR ),
	                		new SqlParameter( "fax_in", Types.VARCHAR ),
	                		new SqlParameter( "crDateBeginning_in", Types.DATE ),
	                		new SqlParameter( "crDateExpire_in", Types.DATE ),
		    				new SqlOutParameter("result", Types.BIGINT ));
	                       
	
	    		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	            
	    				
	    			Map<String, Object> result = new HashMap<String, Object>(2);
	    				result.put("vendorID_in",vendor.vendorID);
	    				result.put("userID_in",vendor.userID);
	    				result.put("vendorNameEn_in", vendor.vendorNameEn);
	    				result.put("vendorNameAr_in", vendor.vendorNameAr);
	    				result.put("vendorTypeID_in", vendor.vendorTypeID);
	    				result.put("email_in", vendor.email);
	    				result.put("lanNumber_in", vendor.lanNumber);
	    				result.put("mobileNumber_in", vendor.mobileNumber);
	    				result.put("webSiteurl_in", vendor.webSiteurl);
	    				result.put("crNumber_in", vendor.crNumber);
	    				result.put("fax_in", vendor.fax);
	    				result.put("crDateBeginning_in", formatter.parse(vendor.crDateBeginning));
	    				result.put("crDateExpire_in", formatter.parse(vendor.crDateExpire));
	    				
	    			 
	    				
	    			result = jdbcCall.execute(result);
	    			
	    			return (Long) result.get("result");
	  
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		
	    		 return Long.valueOf(0); 
	    	}	
	            
	}
	  
	  
	  public Integer AddBank(Bank bank) {
	    	
	    	try {
	    		
	    		SimpleJdbcCall jdbcCall = new 
	                SimpleJdbcCall(dataSource).withProcedureName("AddBank")
	                .withoutProcedureColumnMetaDataAccess().declareParameters(
	                		new SqlParameter( "vendorID_in", Types.BIGINT ),
	                		new SqlParameter( "bankNameID_in", Types.INTEGER ),
	                		new SqlParameter( "iban_in", Types.VARCHAR ),
		    				new SqlOutParameter("result", Types.INTEGER ));
	                       
	
	    				
	    			Map<String, Object> result = new HashMap<String, Object>(2);
	    				result.put("vendorID_in",bank.vendorID);
	    				result.put("bankNameID_in", bank.bankID);
	    				result.put("iban_in", bank.iban);
	    			 
	    				
	    			result = jdbcCall.execute(result);
	    			
	    			return (Integer) result.get("result");
	  
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		
	    		 return 0; 
	    	}	
	            
	}
	  
	  
	  
	  public Integer AddContactPerson(ContactPerson contactPerson) {
	    	
	    	try {
	    		
	    		SimpleJdbcCall jdbcCall = new 
	                SimpleJdbcCall(dataSource).withProcedureName("AddContactPerson")
	                .withoutProcedureColumnMetaDataAccess().declareParameters(
	                		new SqlParameter( "vendorID_in", Types.BIGINT ),
	                		new SqlParameter( "fullName_in", Types.VARCHAR ),
	                		new SqlParameter( "mobile_in", Types.VARCHAR ),
	                		new SqlParameter( "emailPerson_in", Types.VARCHAR ),
		    				new SqlOutParameter("result", Types.INTEGER ));
	                       
	
	    				
	    			Map<String, Object> result = new HashMap<String, Object>(2);
	    				result.put("vendorID_in",contactPerson.vendorID);
	    				result.put("fullName_in", contactPerson.fullName);
	    				result.put("mobile_in", contactPerson.mobile);
	    				result.put("emailPerson_in", contactPerson.emailPerson);
	    			 
	    				
	    			result = jdbcCall.execute(result);
	    			
	    			return (Integer) result.get("result");
	  
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		
	    		 return 0; 
	    	}	
	            
	}
	  
	  
	  
	  public Integer AddBranch(VendorBranches branch) {
	    	
	    	try {
	    		
	    		SimpleJdbcCall jdbcCall = new 
	                SimpleJdbcCall(dataSource).withProcedureName("AddBranch")
	                .withoutProcedureColumnMetaDataAccess().declareParameters(
	                		new SqlParameter( "vendorID_in", Types.BIGINT ),
	                		new SqlParameter( "cityID_in", Types.BIGINT ),
		    				new SqlOutParameter("result", Types.INTEGER ));
	                       
	
	    				
	    			Map<String, Object> result = new HashMap<String, Object>(2);
	    				result.put("vendorID_in",branch.vendorID);
	    				result.put("cityID_in", branch.cityID);
	    			 
	    				
	    			result = jdbcCall.execute(result);
	    			
	    			return (Integer) result.get("result");
	  
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		
	    		 return 0; 
	    	}	
	            
	}
	  
	  public Integer AddVendorProduct(VendorProduct vendorProduct) {
	    	
	    	try {
	    		
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("AddVendorProduct")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "vendorID_in", Types.BIGINT ),
		                		new SqlParameter( "productID_in", Types.BIGINT ),
		                		new SqlParameter( "notes_in", Types.VARCHAR ),
		                		new SqlParameter( "subCatID_in", Types.BIGINT ),
		                		new SqlParameter( "otherProduct_in", Types.VARCHAR ),
		                		
			    				new SqlOutParameter("result", Types.INTEGER ));
		                       
		
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    				result.put("vendorID_in",vendorProduct.vendorID);
		    				result.put("productID_in",vendorProduct.productID);
		    				result.put("notes_in",vendorProduct.notes);	
		    				result.put("subCatID_in",vendorProduct.SubCatID);
		    				result.put("otherProduct_in",vendorProduct.otherProduct);
		    					    				
	    				
	    			result = jdbcCall.execute(result);
	    			
	    			return (Integer) result.get("result");
	  
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		
	    		 return 0; 
	    	}	
	            
	}
	    public  Map<Integer, String> GetAllVendorTypes()
	    {	
	    	  Map<Integer, String> lst = new HashMap<Integer, String>();	      
	    	try {
	        
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetAllVendorTypes")
		                .withoutProcedureColumnMetaDataAccess().declareParameters();	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);    					    				 
		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	    
		    	            
	            for (Map<String, Object> item : list) {	 	            	
	            	lst.put((Integer) (item.get("typeID")), (String) (item.get("typeEn")));    	             	
	            }       	                    
	            
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lst;  
	    	}
	            
	             return lst;  	          
	    
	    }
	    
	    // Get all Bank of vendor 
	    public List<Bank> GetBanks(long vendorID)
	    {
	
	    	List<Bank> lstBank= new ArrayList<Bank>();
	      
	    	try {	    		
	        

	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetBanksByVendorID")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "vendorID_in", Types.BIGINT));	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    				result.put("vendorID_in", vendorID);  		    				 

		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");
	           

	            for (Map<String, Object> item : list) {	 
	            	Bank bank = new Bank();
	            	  
	            	bank.bankID=(Long) (item.get("bankID"));
	            	bank.vendorID= vendorID;
	            	bank.bankName=(String)item.get("bankName");
	            	bank.iban=(String)item.get("iban");
	            	
	               	
	            	
	            	lstBank.add(bank);
	            }
	            	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lstBank;  
	    	}
	            
	             return lstBank;   
	    	    
	    }
	    
	    // Get vendor by user id
	    public Vendor GetVendorByUserID(long userID)
	    {  
	    	Vendor vendor = new Vendor();
	    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	    	try {
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetVendorByUserID")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "userID_in", Types.BIGINT));	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    				result.put("userID_in", userID);  		    				 

		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	           

	            for (Map<String, Object> item : list) {	 
	            
	            	vendor.userID=userID;
	            	vendor.vendorID=(Long) (item.get("vendorID"));
	            	vendor.vendorTypeID=(Integer) (item.get("vendorTypeID"));
	            	
	            	vendor.vendorNameEn=(String) (item.get("VendorNameEn"));
	            	vendor.vendorNameAr=(String) (item.get("VendorNameAr"));	
	            	vendor.email=(String) (item.get("email"));
	            	vendor.mobileNumber=(String) (item.get("mobileNumber"));
	            	vendor.lanNumber=(String) (item.get("lanNumber"));
	            	vendor.webSiteurl=(String) (item.get("webSiteurl"));
	            	vendor.crNumber=(String) (item.get("crNumber"));
	            	vendor.fax=(String) (item.get("fax"));
	            	vendor.crDateBeginning=formatter.format(item.get("crDateBeginning"));
	            	vendor.crDateExpire=formatter.format(item.get("crDateExpire"));
	            	

	            }
	            	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return vendor;  
	    	}
	            
	             return vendor;   
	    	    
	    }

	    
	    
	    public int deleteBank(long bankID)    {
	 	   
	    	try {	    		
	        
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("DeleteBank")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "bankID_in", Types.INTEGER ),		                		
			    				new SqlOutParameter("result", Types.INTEGER ));                     
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    				result.put("bankID_in", bankID);  				
		    			 
		    				
		    			result = jdbcCall.execute(result);
		    			
		    			return (Integer) result.get("result");		                        	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return 0;  
	    	}        
	    }
	    
	    public  Map<Long, String> GetAllCategory()
	    {	
	    	  Map<Long, String> lst = new HashMap<Long, String>();	      
	    	try {
	        
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetAllCategory")
		                .withoutProcedureColumnMetaDataAccess().declareParameters();	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);    					    				 
		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	    
		    	            
	            for (Map<String, Object> item : list) {	 	            	
	            	lst.put((Long) (item.get("catID")), (String) (item.get("catName")));    	             	
	            }       	                    
	            
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lst;  
	    	}
	            
	             return lst;  	          
	    
	    }
	    public  Map<Long, String> GetSubCategory(Long CatID)
	    {	
	    	  Map<Long, String> lst = new HashMap<Long, String>();	      
	    	try {
	        
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetSubCategoryByCatID")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "catID_in", Types.BIGINT));	  	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);  
		    			result.put("catID_in", CatID);  		
		    			
		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	    
		    	            
	            for (Map<String, Object> item : list) {	 	            	
	            	lst.put((Long) (item.get("subCatID")), (String) (item.get("subCatName")));    	             	
	            }       	                    
	            
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lst;  
	    	}
	            
	             return lst;  	          
	    
	    }
	    
	 
	    
	 // Get all Contact Person of vendor 
	    public List<ContactPerson> GetContactPerson(long vendorID)
	    {
	
	    	List<ContactPerson> lstContactPerson= new ArrayList<ContactPerson>();
	      
	    	try {	    		
	        

	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetContactPersonByVendorID")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "vendorID_in", Types.BIGINT));	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    				result.put("vendorID_in", vendorID);  		    				 

		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");
	           

	            for (Map<String, Object> item : list) {	 
	            	ContactPerson contactPerson = new ContactPerson();
	            	  
	            	contactPerson.contactPersonID=(Long) (item.get("contactPersonID"));
	            	contactPerson.vendorID= vendorID;
	            	contactPerson.fullName=(String)item.get("fullName");
	            	contactPerson.mobile=(String)item.get("mobile");
	            	contactPerson.emailPerson=(String)item.get("emailPerson");
	            	
	               	
	            	
	            	lstContactPerson.add(contactPerson);
	            }
	            	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lstContactPerson;  
	    	}
	            
	             return lstContactPerson;   
	    	    
	    }
	    
	    
	    public int deleteContactPerson(long contactPersonID)    {
		 	   
	    	try {	    		
	        
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("DeleteContactPerson")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "contactPersonID_in", Types.BIGINT ),		                		
			    				new SqlOutParameter("result", Types.INTEGER ));                     
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    				result.put("contactPersonID_in", contactPersonID);  				
		    			 
		    				
		    			result = jdbcCall.execute(result);
		    			
		    			return (Integer) result.get("result");		                        	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return 0;  
	    	}        
	    }
	    
	    public  Map<Long, String> GetProducts(Long SubCatID)
	    {	
	    	  Map<Long, String> lst = new HashMap<Long, String>();	      
	    	try {
	        
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetProductBySubCatID")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "SubCatID_in", Types.BIGINT));	  	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);  
		    			result.put("SubCatID_in", SubCatID);  		
		    			
		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	    
		    	            
	            for (Map<String, Object> item : list) {	 	            	
	            	lst.put((Long) (item.get("productID")), (String) (item.get("productName")));    	             	
	            }       	                    
	            
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lst;  
	    	}
	            
	             return lst;  	          
	    
	    }
	    
	    // Get all VendorProduct by VendorID 
	    public List<VendorProduct> GetVendorProductByID(long VendorID)
	    {  
	    	
	    	List<VendorProduct> lst = new ArrayList<VendorProduct>();
	    	try {
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetVendorProductByID")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "VendorID_in", Types.BIGINT));	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    				result.put("VendorID_in", VendorID);  		    				 

		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	           

	            for (Map<String, Object> item : list) {	 
	            	VendorProduct vendorProduct = new VendorProduct();
	            	vendorProduct.vendorID=VendorID;
	            	vendorProduct.vendorProductID=(Long) (item.get("vendorProductID"));	            	
	            	vendorProduct.SubCatID=(Long) (item.get("subCatID"));
	            	vendorProduct.productID=(Long) (item.get("productID"));           	
            	
	            	vendorProduct.catName=(String) (item.get("catName"));
	            	vendorProduct.subCatName=(String) (item.get("subCatName"));
	            	vendorProduct.productName=(String) (item.get("productName"));
	            	vendorProduct.notes=(String) (item.get("notes"));
	            	
	            	lst.add(vendorProduct);
	            }
	            	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lst;  
	    	}
	            
	             return lst;   
	    	    
	    }
	    public int DeleteVendorProduct(long vendorProductID)    {
		 	   
	    	try {	    		
	        
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("DeleteVendorProduct")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "vendorProductID_in", Types.INTEGER ),		                		
			    				new SqlOutParameter("result", Types.INTEGER ));                     
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    				result.put("vendorProductID_in", vendorProductID);  				
		    			 
		    				
		    			result = jdbcCall.execute(result);
		    			
		    			return (Integer) result.get("result");		                        	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return 0;  
	    	}        
	    }
	    
		public Integer UpdatStatus(long vendorID, int statusID, String commentReason) {
			
			try {
				    		
				    		SimpleJdbcCall jdbcCall = new 
				                SimpleJdbcCall(dataSource).withProcedureName("UpdateStatus")
				                .withoutProcedureColumnMetaDataAccess().declareParameters(
				                		new SqlParameter( "vendorID_in", Types.BIGINT ),
				                		new SqlParameter( "statusID_in", Types.INTEGER ),
				    					new SqlParameter( "comment_in", Types.VARCHAR ));
				                       
				
				    				
				    			Map<String, Object> result = new HashMap<String, Object>(2);
				    			
				    			result.put("vendorID_in",vendorID);
				    			result.put("statusID_in", statusID);
				    			result.put("comment_in", commentReason);
				    			
				    				
				    				
				    			 
				    				
				    			result = jdbcCall.execute(result);
				    			
				    			return (Integer) result.get("result");
				  
				             
				    	}catch(Exception ex)
				    	{
				    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
				    		
				    		  
				    	}	
						return 0;
						
					}
		
		public  Map<Integer, String> GetAllCountries()
	    {	
	    	  Map<Integer, String> lst = new HashMap<Integer, String>();	      
	    	try {
	        
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetAllCountries")
		                .withoutProcedureColumnMetaDataAccess().declareParameters();	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);    					    				 
		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	    
		    	            
	            for (Map<String, Object> item : list) {	 	            	
	            	lst.put((Integer) (item.get("countryID")), (String) (item.get("countryName")));    	             	
	            }       	                    
	            
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lst;  
	    	}
	            
	             return lst;  	          
	    
	    }
	    public  Map<Integer, String> GetAllStates(Integer countryID)
	    {	
	    	  Map<Integer, String> lst = new HashMap<Integer, String>();	      
	    	try {
	        
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetAllStatesByID")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "countryID_in", Types.INTEGER));	  	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);  
		    			result.put("countryID_in", countryID);  		
		    			
		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	    
		    	            
	            for (Map<String, Object> item : list) {	 	            	
	            	lst.put((Integer) (item.get("stateID")), (String) (item.get("stateName")));    	             	
	            }       	                    
	            
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lst;  
	    	}
	            
	             return lst;  	          
	    
	    }
	    
	    
	    public  Map<Integer, String> GetAllCities(Integer stateID)
	    {	
	    	  Map<Integer, String> lst = new HashMap<Integer, String>();	      
	    	try {
	        
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetAllCitiesByID")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "stateID_in", Types.INTEGER));	  	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);  
		    			result.put("stateID_in", stateID);  		
		    			
		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	    
		    	            
	            for (Map<String, Object> item : list) {	 	            	
	            	lst.put((Integer) (item.get("cityID")), (String) (item.get("cityName")));    	             	
	            }       	                    
	            
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lst;  
	    	}
	            
	             return lst;  	          
	    
	    }
	    
	    
	    
	    
	 // Get all VendorBranch by VendorID 
	    public List<VendorBranches> GetVendorBranchesByID(long VendorID)
	    {  
	    	
	    	List<VendorBranches> lst = new ArrayList<VendorBranches>();
	    	try {
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetVendorBranchesByID")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "VendorID_in", Types.BIGINT));	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    				result.put("VendorID_in", VendorID);  		    				 

		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	           

	            for (Map<String, Object> item : list) {	 
	            	VendorBranches vendorBranches = new VendorBranches();
	            	
	            	vendorBranches.vendorID=VendorID;
	            	vendorBranches.branchesID=(Long) (item.get("branchesID"));	            	
	            	vendorBranches.cityID=(Integer) (item.get("cityID"));
	            	vendorBranches.stateID=(Integer) (item.get("stateID"));
	            	vendorBranches.countryID=(Integer) (item.get("countryID"));
            	
	            	vendorBranches.cityName=(String) (item.get("cityName"));
	            	vendorBranches.stateName=(String) (item.get("stateName"));
	            	vendorBranches.countryName=(String) (item.get("countryName"));
	            	vendorBranches.sortname=(String) (item.get("sortname"));
	            	
	            	lst.add(vendorBranches);
	            }
	            	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lst;  
	    	}
	            
	             return lst;   
	    	    
	    }
	    public int DeleteVendorBranches(long branchesID)    {
		 	   
	    	try {	    		
	        
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("DeleteBranche")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "branchesID_in", Types.BIGINT ),		                		
			    				new SqlOutParameter("result", Types.INTEGER ));                     
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    				result.put("branchesID_in", branchesID);  				
		    			 
		    				
		    			result = jdbcCall.execute(result);
		    			
		    			return (Integer) result.get("result");		                        	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return 0;  
	    	}        
	    }
	    
	   
	    
	    public List<AttachmentType> GetAttachmentTypes()
	    {
	
	    	List<AttachmentType> lstType= new ArrayList<AttachmentType>();
	      
	    	try {	    		
	        

	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetAllAttachmentTypes")
		                .withoutProcedureColumnMetaDataAccess().declareParameters();
		                			            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    						    				 

		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");
	           

	            for (Map<String, Object> item : list) {	 
	            	AttachmentType type = new AttachmentType();
	            	  
	            	type.attachmentTypeID=(Integer) (item.get("attachmentTypeID"));	            
	            	type.attachmentAr=(String)item.get("attachmentAr");
	            	type.attachmentEn=(String)item.get("attachmentEn");
	            	
	               	
	            	
	            	lstType.add(type);
	            }
	            	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lstType;  
	    	}
	            
	             return lstType;   
	    	    
	    }
	    public Integer AddAttachment(Attachment attachment) {
	    	
	    	try {
	    		
	    		SimpleJdbcCall jdbcCall = new 
	                SimpleJdbcCall(dataSource).withProcedureName("AddAttachment")
	                .withoutProcedureColumnMetaDataAccess().declareParameters(
	                		new SqlParameter( "vendorID_in", Types.BIGINT ),
	                		new SqlParameter( "attachmentTypeID_in", Types.INTEGER ),
	                		new SqlParameter( "fileName_in", Types.VARCHAR ),	
	                		new SqlParameter( "url_in", Types.VARCHAR ),	
		    				new SqlOutParameter("result", Types.INTEGER ));
	                       
	
	    				
	    			Map<String, Object> result = new HashMap<String, Object>(2);
	    				result.put("vendorID_in",attachment.vendorID);
	    				result.put("attachmentTypeID_in", attachment.attachmentTypeID);
	    				result.put("fileName_in", attachment.fileName);
	    				result.put("url_in", attachment.url);
	    				
	    			 
	    				
	    			result = jdbcCall.execute(result);
	    			
	    			return (Integer) result.get("result");
	  
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		
	    		 return 0; 
	    	}	
	            
	}
	    
	    public List<Attachment> GetAllAttachments(long VendorID)
	    {
	
	    	List<Attachment> lst= new ArrayList<Attachment>();
	      
	    	try {	    		
	        

	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetAllAttachments")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
	    		new SqlParameter( "vendorID_in", Types.BIGINT));		            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    			result.put("vendorID_in", VendorID);  		    				 

		    				result = jdbcCall.execute(result);
		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");          

	            for (Map<String, Object> item : list) {	 
	            	Attachment attachment = new Attachment();
	            	attachment.vendorID=VendorID;
	            	attachment.attachmentID=(Long) (item.get("attachmentID"));	
	            	attachment.attachmentTypeID=(Integer) (item.get("attachmentTypeID"));	            
	            	attachment.fileName=(String)item.get("fileName");
	            	attachment.attachmentEn=(String)item.get("attachmentEn");
	            	attachment.attachmentAr=(String)item.get("attachmentAr");
	            	attachment.url=(String)item.get("url");
 	
 	
	            	lst.add(attachment);
	            }
	            	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lst;  
	    	}
	            
	             return lst;   
	    	    
	    }
	    
	    // Get vendor status and comments
	    public Vendor GetVendorStatus(long userID)
	    {  
	    	Vendor vendor = new Vendor();
	    	try {
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetVendorStatus")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "userID_in", Types.BIGINT));	            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    				result.put("userID_in", userID);  		    				 

		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	           

	            for (Map<String, Object> item : list) {	 
	            
	            	vendor.userID=userID;
	            	vendor.vendorID=(Long) (item.get("vendorID"));	
	            	vendor.vendorNameEn=(String) (item.get("VendorNameEn"));
	            	vendor.vendorNameAr=(String) (item.get("VendorNameAr"));	
	            	vendor.statusAr=(String) (item.get("statusAr"));
	            	vendor.statusEn=(String) (item.get("statusEn"));
	            	vendor.commentReason=(String) (item.get("commentReason"));            		            	
	            }
            
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return vendor;  
	    	}
	            
	             return vendor;   
	    	    
	    }	  
	    public Attachment GetAttachment(long userID ,long attachmentID)
	    {
	
	    	Attachment attachment = new Attachment();
	      
	    	try {	
	    				SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetAttachment")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "userID_in", Types.BIGINT),
		                		new SqlParameter( "attachmentID_in", Types.BIGINT));		            			    				                   
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    			result.put("userID_in", userID);  	
		    			result.put("attachmentID_in", attachmentID);  

		    				result = jdbcCall.execute(result);
		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");          

	            for (Map<String, Object> item : list) {	 	            	
	            	attachment.attachmentID=attachmentID;
	            	attachment.vendorID=(Long) (item.get("vendorID"));	
	            	attachment.attachmentTypeID=(Integer) (item.get("attachmentTypeID"));	            
	            	attachment.fileName=(String)item.get("fileName");	
	            	attachment.url=(String)item.get("url");
	            }	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return attachment;  
	    	}
	            
	             return attachment;   
	    	    
	    }
	    public int DeleteAttachment(long attachmentID)    {
		 	   
	    	try {	    		
	        
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("DeleteAttachment")
		                .withoutProcedureColumnMetaDataAccess().declareParameters(
		                		new SqlParameter( "attachmentID_in", Types.INTEGER ),		                		
			    				new SqlOutParameter("result", Types.INTEGER ));                     
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    				result.put("attachmentID_in", attachmentID);  				
		    			 
		    				
		    			result = jdbcCall.execute(result);
		    			
		    			return (Integer) result.get("result");		                        	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return 0;  
	    	}        
	    }

		@Override
		public Map<Integer, String> GetAllBankName() {
			 Map<Integer, String> lst = new HashMap<Integer, String>();	      
		    	try {
		        
		    		SimpleJdbcCall jdbcCall = new 
			                SimpleJdbcCall(dataSource).withProcedureName("GetAllBankName")
			                .withoutProcedureColumnMetaDataAccess().declareParameters();	            			    				                   
			    				
			    			Map<String, Object> result = new HashMap<String, Object>(2);    					    				 
			    				result = jdbcCall.execute(result);

			    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	    
			    	            
		            for (Map<String, Object> item : list) {	 	            	
		            	lst.put((Integer) (item.get("bankNameID")), (String) (item.get("bankName")));    	             	
		            }       	                    
		            
		    	}catch(Exception ex)
		    	{
		    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
		    		 return lst;  
		    	}
		            
		             return lst;  	   
			}
		
		@Override
		public Map<Integer, String> GetAllCompanyTypes() {
			 Map<Integer, String> lst = new HashMap<Integer, String>();	      
		    	try {
		        
		    		SimpleJdbcCall jdbcCall = new 
			                SimpleJdbcCall(dataSource).withProcedureName("GetAllCommpanyTypes")
			                .withoutProcedureColumnMetaDataAccess().declareParameters();	            			    				                   
			    				
			    			Map<String, Object> result = new HashMap<String, Object>(2);    					    				 
			    				result = jdbcCall.execute(result);

			    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");	    
			    	            
		            for (Map<String, Object> item : list) {	 	            	
		            	lst.put((Integer) (item.get("typeID")), (String) (item.get("typeEn")));    	             	
		            }       	                    
		            
		    	}catch(Exception ex)
		    	{
		    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
		    		 return lst;  
		    	}
		            
		             return lst;  	   
			}

		@Override
		public List<Vendor> GetAllExpiredCRDate() {
			List<Vendor> lstUser= new ArrayList<Vendor>();
		      
	    	try {	
	    		
	    		SimpleJdbcCall jdbcCall = new 
		                SimpleJdbcCall(dataSource).withProcedureName("GetAllExpiredCRDate")
		                .withoutProcedureColumnMetaDataAccess().declareParameters();
		                
	    		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		    				
		    			Map<String, Object> result = new HashMap<String, Object>(2);
		    						    				 

		    				result = jdbcCall.execute(result);

		    	            List<Map<String, Object>> list = (List) result.get("#result-set-1");

	            for (Map<String, Object> item : list) {	 
	            	Vendor vendor = new Vendor();
	            	  
	            	vendor.vendorID=(Long) (item.get("vendorID"));
	            	vendor.vendorNameEn= (String) (item.get("vendorNameEn"));
	            	vendor.vendorNameAr=(String)item.get("vendorNameAr");
	            	vendor.mobileNumber=(String) (item.get("mobileNumber"));
	            	vendor.email=(String) (item.get("email"));
	            	vendor.statusAr=(String) (item.get("statusAr"));
	            	vendor.statusEn=(String) (item.get("statusEn"));
	            	vendor.crDateBeginning=formatter.format(item.get("crDateBeginning"));
	            	vendor.crDateExpire= formatter.format(item.get("crDateExpire"));
	            	        	
	            	
	            	lstUser.add(vendor);
	            }
	            	            
	        
	             
	    	}catch(Exception ex)
	    	{
	    		new ExceptionImp().LogException(dataSource,Thread.currentThread().getStackTrace()[1].getMethodName(),ex.toString());
	    		 return lstUser;  
	    	}
	            
	             return lstUser;  
		}
}
	    
