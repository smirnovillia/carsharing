<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="baseUrl" value="${contextPath}/brand" />
<h4 class="header">Brands</h4>
<table class="bordered highlight">
    <tbody>
        <tr>
            <th>id</th>
            <th>name</th>
            <!-- th>created</th>
            <th>updated</th-->
            <th></th>
        </tr>
        <c:forEach var="brand" items="${list}" varStatus="loopCounter">
            <tr>
                <td><c:out value="${brand.id}" /></td>
                <td><c:out value="${brand.name}" /></td>
                <%-- <td><fmt:formatDate pattern="yyyy-MM-dd" value="${brand.created}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${brand.updated}" /></td> --%>
                <td class="right"><a class="btn-floating" href="${baseUrl}/${brand.id}"><i class="material-icons">info</i></a> <a
                    class="btn-floating" href="${baseUrl}/${brand.id}/edit"><i class="material-icons">edit</i></a> <a
                    class="btn-floating red disabled" href="${baseUrl}/${brand.id}/delete"><i class="material-icons">delete</i></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a class="waves-effect waves-light btn right" href="${baseUrl}/add"><i class="material-icons">add</i></a>