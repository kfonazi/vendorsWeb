 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vendor Product</title>
</head>
<body>

   <jsp:include page="/WEB-INF/views/header.jsp"/>
   
  <div align="center">
 

    <form:form method="post" modelAttribute="vendorProduct">
    
    
       <div class="form-group row">

    <h2><span class="glyphicon glyphicon-folder-open" ></span>     Products         </h2>             
            </div>
                  <div class="form-group row">                <div class="col-sm-1"> </div>        
 <div class="col-sm-10"><div class='alert alert-danger ${alert.getVisible()}' id='alertBar' role="alert"> <i class="fa fa-exclamation-triangle fa-2x" aria-hidden="true"></i> <div id='alert'> ${alert.getMessage()}</div>  </div>
       </div><div class="col-sm-1"></div>            </div>  
       
            
                   <div class="form-group row">
                  <div class="col-sm-2"></div>
                <label  class="col-sm-2 col-form-label">Category</label>
                    <div class="col-sm-4">
                     <form:select  path="vendorProductID" class="form-control" id="ddlCategory">
                     <form:option value = "0" label = "Select Category"/>
                     <form:options items = "${categoryList}" />
                  </form:select>   
                    </div>
                     <div class="col-sm-4">                

                     </div>
            </div>
                      
                          <div class="form-group row">
                  <div class="col-sm-2"></div>
                <label  class="col-sm-2 col-form-label">Sub Category</label>
                    <div class="col-sm-4">                     
                     <form:select  path="SubCatID" class="form-control"  id="ddlSubcategory">
                     <form:option value = "0" label = "Select Sub Category"/>                   
                  </form:select>   </div>
                     <div class="col-sm-4"></div>
            </div>
            
            
                         <div class="form-group row">
                  <div class="col-sm-2"></div>
                <label  class="col-sm-2 col-form-label">Products</label>
                    <div class="col-sm-4"> 
                    <form:select  path="productID" class="form-control"  id="ddlproduct">
                     <form:option value = "0" label = "Select Product"/>                   
                  </form:select></div>
                     <div class="col-sm-2">
                     <form:input  class="form-control invisible" path="otherProduct"   id="otherProduct" placeholder="other Product (if not in list)" /> 
                     </div>  <div class="col-sm-2"></div>
            </div>
             
              <div class="form-group row">
                  <div class="col-sm-2"></div>
                <label  class="col-sm-2 col-form-label">Notes</label>
                    <div class="col-sm-6"><form:textarea  class="form-control" id="txtNote" path="notes" placeholder="Write Note"/></div>
                     <div class="col-sm-2">  </div>
            </div>
 
                
                   <div class="form-group row">
                  <div class="col-sm-3"></div>
                <label  class="col-sm-4 col-form-label"></label>

                    <div class="col-sm-3"><input type="submit"  id= "btnVendorProduct" value="Save" onclick="return validateVendorProduct();" class="btn btn-info" name="vendorProduct"/></div>
                     <div class="col-sm-2"></div>
            </div>
            
              </form:form>
            
                 <div class="form-group row">
                  <div class="col-sm-1"></div>  
        <div class="col-sm-10">
                <c:if test="${not empty productList}">    
        <div align="center">
            <h1></h1>
             <h2>  <i class="glyphicon glyphicon-tags" aria-hidden="true"></i>       Products Lists    </h2>
                    	<table class="table table-sm table-hover table-striped table-bordered">
                    	 <thead class="bg-primary">
                    	<tr>
                 <th class="text-center" scope="col">No</th>
                 <th class="text-center" scope="col">Category  Name</th>
                <th  class="text-center" scope="col">Sub Category Name </th>
                 <th class="text-center" scope="col">Product Name </th>
                <th  class="text-center"scope="col">Details </th>
                  <th scope="col"></th>
                </tr>
    </thead>
                   <tbody>
                  <c:forEach var="product" items="${productList}" varStatus="status">
                <tr>
                    <td class="text-center">${status.index + 1}</td>
                    <td class="text-center">${product.catName}</td>
                    <td class="text-center">${product.subCatName}</td>      
                     <td class="text-center">${product.productName}</td>
                    <td class="text-center">${product.notes}</td>          
                    <th class="text-center">
                       <a type="button" class="btn btn-danger" href="deleteProduct/${product.vendorProductID}" onclick="return confirm('Are you sure you want to delete this item?');"> <span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>                   
                     </th>                             
                </tr>
                </c:forEach>   
                </tbody>          
            </table>
        </div>
        
        	</c:if>        
     </div>
      <div class="col-sm-1"></div>  </div>
      
         <div class="form-group row">
                  
        <div class="col-sm-1"></div>
       <div class="col-sm-10">
      
       <c:if test="${not empty attachmentList}">    
        <div align="center">
            <h1></h1>
             <h2><span class="glyphicon glyphicon-edit" ></span>        Attachment List       </h2>
                    	<table class="table table-sm table-hover table-striped table-bordered">
                    	  <thead class="bg-primary ">
                    	<tr>
                 <th class="text-center" scope="col">No</th>
                 <th class="text-center" scope="col">Attachment Name</th>
                 <th class="text-center" scope="col">Download</th>    
                 <th scope="col"></th>
                </tr>
    </thead>
                   <tbody>
                <c:forEach var="attachList" items="${attachmentList}" varStatus="status">
                <tr>
                    <td class="text-center">${status.index + 1}</td> 
                    <td class="text-center">
                    
                    <c:set var="typeId" value="${attachList.attachmentTypeID}"/> 
                    <c:if test="${typeId >0}"> 
                         ${attachList.attachmentEn}
                          
                          </c:if>                 
                         <c:if test="${typeId ==0}"> 
                         ${attachList.fileName}
                          
                          </c:if>  
                    
                    
                    </td>
                    <td class="text-center"><a href="downloadFile/${attachList.attachmentID}" target="_blank"> <i class="fa fa-cloud-download fa-2x" aria-hidden="true"></i></a></td>              
                     <th  class="text-center">
                       <a type="button" class="btn btn-danger" href="deleteAttachment/${attachList.attachmentID}" onclick="return confirm('Are you sure you want to delete this item?');"> <span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>                   
                     </th>                            
                </tr>
                </c:forEach>   
                </tbody>          
            </table>
        </div>
        
        	</c:if>  
      
      </div>    <div class="col-sm-1"></div></div>
      

                       <div class="form-group row">
                    <div class="col-sm-1"></div>
        <div class="col-sm-10">
                <c:if test="${not empty attachmentTypeList}">    
        <div align="center">
            <h1></h1>
             <h2><i class="fa fa-paperclip  fa-2x" aria-hidden="true"></i>   Upload   Attachments    </h2>
          
            
                    	
                    	<table class="table table-sm table-hover table-striped table-bordered">
                    	 <thead class="bg-primary ">
                    	<tr>
                 <th class="text-center" scope="col">No</th>
                 <th class="text-center" scope="col">Attachment  Name Ar</th>
                 <th class="text-center" scope="col">Attachment  Name En</th>
                 <th class="text-center" scope="col">File <h5 > ${message}</h5></th>              
                </tr>
    </thead>
                   <tbody>
                  <c:forEach var="type" items="${attachmentTypeList}" varStatus="status">
                <tr>
                    <td class="text-center">${status.index + 1}</td>
                    <td class="text-center">${type.attachmentAr}</td>
                    <td class="text-center">${type.attachmentEn}</td>
                    <td colspan="1"> 
  
                           <form method="post" action="uploadFile" enctype="multipart/form-data">     
              <div class="form-group row"> 
               <div class="col-sm-4"> <input type="text" name="name" value=${type.fileName} class="invisible">
               <input type="text" name="typeID" value=${type.attachmentTypeID} class="invisible"></div>
             <div class="col-sm-4">  <input type="file" name="file"/> </div>
              <div class="col-sm-4"><button type="submit" class="btn btn-info"   > <i class="fa fa-cloud-upload " aria-hidden="true"> </i>Upload</button>
              
              </div>
              
                              
           </div>
        </form>                    
                    </td>                     
                     
                </tr>
                </c:forEach>  
                 
                                <tr class="text-center">
                    <td></td>
                    <td class="text-center">Other Attachements</td>
                    <td class="text-center" colspan="2"> 
  
                           <form method="post" action="uploadFile" enctype="multipart/form-data">     
              <div class="form-group row"> 
               <div class="col-sm-4"> Attachement Name <input type="text" name="name"  >
               <input type="text" name="typeID" value=0 class="invisible"></div>
             <div class="col-sm-4">  <input type="file" name="file"/> </div>
              <div class="col-sm-4"><button type="submit" class="btn btn-info"   > <i class="fa fa-cloud-upload " aria-hidden="true"> </i>Upload</button>
              
              </div>
              
                              
           </div>
        </form>                    
                    </td>                       
                   
                                               
                </tr>
                
                </tbody>          
            </table>
        </div>
        
        	</c:if>        
     </div>
     <div class="col-sm-1"></div>  </div>
      
                     
      
        <form:form method="post" >
    
         <div class="form-group row">
                  <div class="col-sm-3"></div>
                <label  class="col-sm-4 col-form-label"></label>

                    <div class="col-sm-3"></div>
                     <div class="col-sm-2"></div>
            </div>
            
                <div class="form-group row">
                  <div class="col-sm-2"></div>
                <label  class="col-sm-2 col-form-label"></label>
                     <div class="col-sm-2"><a href="vendorInfo"  class="btn btn-warning" > Back</a></div>
                      <div class="col-sm-2"></div>
                      <div class="col-sm-2">
                      <input type="submit" value="submit Profile"  class="btn btn-success"  name="completeProfile"/></div>
                     <div class="col-sm-2"></div>
                     
                     
            </div>
           </form:form> 
    </div>
    
    
     <jsp:include page="/WEB-INF/views/footer.jsp"/>
     
                  <script language="javascript" type="text/javascript"> 
                  
     $(document).ready(function() { 
    	    	
    		$('#ddlCategory').change(    				
    			function() {
    				
    				var selectedID  =$( "#ddlCategory option:selected" ).val()
    				$.ajax({    					
    				     type: "GET",
    				     url: "GetSubCategory",    				    
    				     data: { id: selectedID } ,// parameters
    				     success : function(response) {    				    	
    				    	 var json = JSON.parse(response);    
    				    	 populateDropdown( '#ddlSubcategory', json)    	
    				    	 clearDropdown('#ddlproduct');
    		                },
    		                error : function(xhr, status, error) {
    		                 /*    alert(xhr.responseText);
    		                    alert(xhr.error); */
    		                }
    		            }); });	
    		
    		
    		$('#ddlSubcategory').change(    				
    	 			function() {
    	 				
    	 				var selectedID  =$( "#ddlSubcategory option:selected" ).val();
    	 				var Product  =$( "#ddlSubcategory option:selected" ).text()
    	 				    	 			
    	 				if(Product=='Other'){
    	 					 $('#otherProduct').removeClass( "invisible" );
    	 	    		  $('#otherProduct').addClass( "visible" );
    	 				}
    	 				else
    	 					{
    	 					 $('#otherProduct').removeClass( "visible" );
       	 	    		  $('#otherProduct').addClass( "invisible" );
    	 					}
    	 				$('#otherProduct').val('');
    	 				
    	 				$.ajax({    					
    	 				     type: "GET",
    	 				     url: "GetProducts",    				    
    	 				     data: { id: selectedID } ,// parameters
    	 				     success : function(response) {    				    	
    	 				    	 var json = JSON.parse(response);    
    	 				    	 populateDropdown( '#ddlproduct', json)       		                     		                
    	 		                },
    	 		                error : function(xhr, status, error) {
    	 		                   /*  alert(xhr.responseText);
    	 		                    alert(xhr.error); */
    	 		                }
    	 		            });
    	 			});	
    		
    		$('#ddlproduct').change(    				
    	 			function() {   	 		
    	 				
    	 				var Product  =$( "#ddlSubcategory option:selected" ).text()
    	 				var selectedID  =$( "#ddlproduct option:selected" ).val(); 	 			
		    	 			
    	 				if((Product=='Other') && (selectedID==0)){
    	 					 $('#otherProduct').removeClass( "invisible" );
    	 	    		  $('#otherProduct').addClass( "visible" );
    	 				}
    	 				else
    	 					{
    	 					 $('#otherProduct').removeClass( "visible" );
       	 	    		  $('#otherProduct').addClass( "invisible" );
    	 					}
    	 				$('#otherProduct').val('');
    	 	    	});
	
    	});

     
     
     function validateVendorProduct() {  	
    	 $('#alert').empty(); 
    	 var isValid = true;
    	
    		var selectedID  =$( "#ddlproduct option:selected" ).val();	  
    	  
    	  if ($( "#ddlproduct option:selected" ).val()==0)
    	  {    
    		 
    		  if (($("#ddlSubcategory option:selected").text() =='Other')&& ($("#otherProduct").val().length >1))
        	  { 
        		  isValid = true;   		      		  
        	  } else
        	  {    	
        		  $('#alert').append("please select the product details ! ");
        		  isValid = false; 
        	  }
    	  } 
        	   
    	
 	  if (isValid)
	  {    		 
		  $('#alertBar').removeClass( "show" );		  $('#alertBar').addClass( "hide" );			  return true;
	  }
	  else
		  {    		  
		  $('#alertBar').removeClass( "hide" );		  $('#alertBar').addClass( "show" );		$(window).scrollTop(0);  return false;
		  } 
    	
     }
     
        </script>
</body>
</html>