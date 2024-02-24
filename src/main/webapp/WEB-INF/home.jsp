<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>

<div class="container">
  <div class="jumbotron">
    <h1>
      Welcome to eShoppers
    </h1>
    <img src="<c:url value="/image/cart.jpg"/>" style="height: 200p" alt=""/>
  </div>
  <div class="row">
    <c:forEach var="product" items="${products}">
      <div class="col-sm-4">
        <div class="card h-100 mb-4">
          <div class="card-body">
            <h5 class="card-title">
              <c:out value="${product.name}"/>
            </h5>

            <p>
              <c:out value="${product.description}"/>
            </p>

            <p>
              <c:out value="${product.price}"/>
            </p>

            <a href="#" class="card-link btn btn-outline-info"> Add to cart </a>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>

<%@include file="includes/footer.jsp" %>
