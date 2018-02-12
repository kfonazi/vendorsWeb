 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Vendor Profile</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"/>

      <div align="center">
         <form:form method="post" modelAttribute="vendor">


  <div class="form-group row">
<div class="col-sm-12">
    <h2><span class="glyphicon glyphicon-folder-open" ></span>     Vendor Profile         </h2>
     <h4>    vendor Details         </h4>
	</div></div>
	
	<div class="form-group row">
         <form:hidden path="vendorID" />
       
         <form:hidden   class="form-control" path="vendorID" />
         
                  
                <label  class="col-sm-4 col-form-label">Vendor Name English</label>
                    <div class="col-sm-4"><form:input  class="form-control" path="vendorNameEn" disabled="true" /></div>
                     <div class="col-sm-2"></div>
            </div>
            
              <div class="form-group row">
                 
                <label  class="col-sm-4 col-form-label">Vendor Name Arabic</label>
                    <div class="col-sm-4"><form:input  class="form-control"  path="vendorNameAr" disabled="true" /></div>
                     <div class="col-sm-2"></div>
            </div>
                      
            
            
                         <div class="form-group row">
                  
                <label  class="col-sm-4 col-form-label">Email</label>
                    <div class="col-sm-4"><form:input  class="form-control"  path="email" disabled="true"/></div>
                     <div class="col-sm-2"></div>
            </div>
             
             
                                      <div class="form-group row">
                  
                <label  class="col-sm-4 col-form-label">LAN Number </label>
                    <div class="col-sm-4"><form:input  class="form-control" path="lanNumber" disabled="true"/></div>
                     <div class="col-sm-2"></div>
            </div>
            
             						  <div class="form-group row">
                  
                <label  class="col-sm-4 col-form-label">Mobile Number </label>
                    <div class="col-sm-4"><form:input  class="form-control" path="mobileNumber" disabled="true"/></div>
                     <div class="col-sm-2"></div>
            </div>
            
             						  <div class="form-group row">
                  
                <label  class="col-sm-4 col-form-label">Web Site URL</label>
                    <div class="col-sm-4"><form:input  class="form-control" path="webSiteurl" disabled="true"/></div>
                     <div class="col-sm-2"></div>
            </div>
            
             						  <div class="form-group row">
                  
                <label  class="col-sm-4 col-form-label">C/R Number </label>
                    <div class="col-sm-4"><form:input  class="form-control" path="crNumber" disabled="true"/></div>
                     <div class="col-sm-2"></div>
            </div>     
      
      
       		         <div class="form-group row">
                    <div class="col-sm-2"></div>
        <div class="col-sm-8">
                <c:if test="${not empty productList}">    
        <div align="center">
            <h1></h1>
             <h2><span class="glyphicon glyphicon-edit" ></span>        Product List       </h2>
                    	<table class="table table-sm table-hover table-striped table-bordered">
                    	  <thead class="bg-primary ">​
                    	  <tr>
                 <th scope="col">No</th>
                 <th scope="col">Product Name</th>
                <th scope="col">Category Name</th>
                <th scope="col">Sub Category Name</th>
                <th scope="col">Notes</th>                 
                </tr>
    </thead>
                   <tbody>
                <c:forEach var="productList" items="${productList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${productList.productName}</td>
                    <td>${productList.catName}</td>
                    <td>${productList.subCatName}</td>
                    <td>${productList.notes}</td>              
                                               
                </tr>
                </c:forEach>   
                </tbody>          
            </table>
        </div>
        
        	</c:if>        
     </div>
     <div class="col-sm-2"></div>
        </div>
      
       		         <div class="form-group row">
                  <div class="col-sm-2"></div> 
        <div class="col-sm-4">
                <c:if test="${not empty bankList}">    
        <div align="center">
            <h1></h1>
             <h2><span class="glyphicon glyphicon-edit" ></span>        Banks       </h2>
                    	<table class="table table-sm table-hover table-striped table-bordered">
                    	  <thead class="bg-primary ">
                    	<tr>
                 <th scope="col">No</th>
                 <th scope="col">Bank Name</th>
                <th scope="col">IBAN</th>                 
                  
                </tr>
    </thead>
                   <tbody>
                <c:forEach var="bank" items="${bankList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${bank.bankName}</td>
                    <td>${bank.iban}</td>              
                  
                                    
                                                 
                </tr>
                </c:forEach>   
                </tbody>          
            </table>
        </div>
        
        	</c:if>        
     </div>
       
      
      
                    
        <div class="col-sm-4">
                <c:if test="${not empty contactList}">    
        <div align="center">
            <h1></h1>
             <h2><span class="glyphicon glyphicon-edit" ></span>        Contact List       </h2>
                    	<table class="table table-sm table-hover table-striped table-bordered">
                    	  <thead class="bg-primary ">
                    	<tr>
                 <th scope="col">No</th>
                 <th scope="col">Full Name</th>
                <th scope="col">Mobile</th>
                <th scope="col">Email</th>                 
                  
                </tr>
    </thead>
                   <tbody>
                <c:forEach var="contactList" items="${contactList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${contactList.fullName}</td>
                    <td>${contactList.mobile}</td> 
                    <td>${contactList.email}</td>              
                                               
                </tr>
                </c:forEach>   
                </tbody>          
            </table>
        </div>
        
        	</c:if>        
     </div>
        <div class="col-sm-2"></div> </div>
      
      <div class="form-group row">
      
                        <div class="col-sm-2"></div>  
        <div class="col-sm-8">
                <c:if test="${not empty branchesList}">    
        <div align="center">
            <h1></h1>
             <h2><span class="glyphicon glyphicon-edit" ></span>        Branches List       </h2>
                    	<table class="table table-sm table-hover table-striped table-bordered">
                    	  <thead class="bg-primary ">
                    	<tr>
                 <th scope="col">No</th>
                 <th scope="col">Country Name</th>
                <th scope="col">State Name</th>
                <th scope="col">City Name</th>
                <th scope="col">Sort Name</th>                 
                  
                </tr>
    </thead>
                   <tbody>
                <c:forEach var="branchesList" items="${branchesList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${branchesList.countryName}</td>
                    <td>${branchesList.stateName}</td> 
                    <td>${branchesList.cityName}</td>
                    <td>${branchesList.sortname}</td>              
                                              
                </tr>
                </c:forEach>   
                </tbody>          
            </table>
        </div>
        
        	</c:if>        
     </div>
     <div class="col-sm-2"></div>
        </div>
      
            <div class="form-group row">
      
                        <div class="col-sm-2"></div>  
        <div class="col-sm-8">
                <c:if test="${not empty attachList}">    
        <div align="center">
            <h1></h1>
             <h2><span class="glyphicon glyphicon-edit" ></span>        Attachment List       </h2>
                    	<table class="table table-sm table-hover table-striped table-bordered">
                    	  <thead class="bg-primary ">
                    	<tr>
                 <th scope="col">No</th>
                <th scope="col">Attachment En</th>
                <th scope="col">Attachment Ar</th>
                <th scope="col">Download</th>    
                
                </tr>
    </thead>
                   <tbody>
                <c:forEach var="attachList" items="${attachList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td> 
                    <td>
                    
                    <c:set var="typeId" value="${attachList.attachmentTypeID}"/> 
                    <c:if test="${typeId >0}"> 
                         ${attachList.attachmentEn}
                          
                          </c:if>                 
                         <c:if test="${typeId ==0}"> 
                         ${attachList.fileName}
                          
                          </c:if>  
                    
                    
                    </td>
                    <td>${attachList.attachmentAr}</td>
                    <td><a href="downloadFile/${attachList.attachmentID}" target="_blank"> <i class="fa fa-cloud-download fa-2x" aria-hidden="true"></i></a></td>              
                                             
                </tr>
                </c:forEach>   
                </tbody>          
            </table>
        </div>
        
        	</c:if>        
     </div>
     <div class="col-sm-2"></div>
        </div>
      </form:form>      
 		
 		
    </div>
 

</body>
</html>