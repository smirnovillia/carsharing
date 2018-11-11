<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>

<h4 class="header">Cars</h4>
<table class="bordered highlight">
    <tbody>
        <tr>
            <th><mytaglib:sort-link pageUrl="${pagesCar}" column="id">id</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesCar}" column="vin">vin</mytaglib:sort-link></th>
            <th>model</th>
            <th><mytaglib:sort-link pageUrl="${pagesCar}" column="created">created</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesCar}" column="updated">updated</mytaglib:sort-link></th>
            <th></th>
        </tr>
        <c:forEach var="car" items="${gridItems}" varStatus="loopCounter">
            <tr>
                <td><c:out value="${car.id}" /></td>
                <td><c:out value="${car.vin}" /></td>
                <td><c:out value="${car.modelName}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${car.created}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${car.updated}" /></td>
                <td class="right"><a class="btn-floating" href="${pagesCar}/${car.id}"><i class="material-icons">info</i></a> <a
                    class="btn-floating" href="${pagesCar}/${car.id}/edit"><i class="material-icons">edit</i></a> <a class="btn-floating red"
                    href="${pagesCar}/${car.id}/delete"><i class="material-icons">delete</i></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jspFragments:paging />
<a class="waves-effect waves-light btn right" href="${pagesCar}/add"><i class="material-icons">add</i></a>