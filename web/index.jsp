<%-- 
    Document   : index
    Created on : Nov 7, 2019, 9:05:49 AM
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="category-tab"><!--category-tab-->
    <div class="col-sm-12">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#tshirt" data-toggle="tab">Sản phẩm</a></li>
        </ul>
    </div>
    <div class="tab-content">
        <div class="tab-pane fade active in" id="tshirt" >
            <c:forEach var="product" items="${newProduct}">
            <div class="col-sm-3">
                <div class="product-image-wrapper">
                    <div class="single-products">
                        <div class="productinfo text-center">
                            <img src="images/sanpham/${product.getImage()}" alt="" />
                            <h2>${product.getPrice()}</h2>
                            <p>${product.getName()}</p>
                            <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                        </div>

                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div><!--/category-tab-->
