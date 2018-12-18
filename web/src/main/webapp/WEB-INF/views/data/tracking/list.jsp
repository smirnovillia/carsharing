<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>

<h4 class="header">Tracking</h4>
<table class="bordered highlight">
    <tbody>
        <tr>
            <th>id</th>
            <th>car</th>
            <th>latitude</th>
            <th>longitude</th>
            <th>created</th>
            <th>updated</th>
            <th></th>
        </tr>
        <c:forEach var="dto" items="${gridItems}" varStatus="loopCounter">
            <tr>
                <td><c:out value="${dto.id}" /></td>
                <td><c:out value="${dto.carId}" /></td>
                <td><c:out value="${dto.latitude}" /></td>
                <td><c:out value="${dto.longitude}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.created}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.updated}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jspFragments:paging />
