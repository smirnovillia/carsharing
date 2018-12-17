<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>

<h4 class="header">Tracking</h4>
<table class="bordered highlight">
    <tbody>
        <tr>
            <th><mytaglib:sort-link pageUrl="${pagesTracking}" column="id">id</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesTracking}" column="carId">car</mytaglib:sort-link></th>
             <th><mytaglib:sort-link pageUrl="${pagesTracking}" column="latitude">latitude</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesTracking}" column="longitude">longitude</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesTracking}" column="created">created</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesTracking}" column="updated">updated</mytaglib:sort-link></th>
            <th></th>
        </tr>
        <c:forEach var="tracking" items="${gridItems}" varStatus="loopCounter">
            <tr>
                <td><c:out value="${tracking.id}" /></td>
                <td><c:out value="${tracking.carId}" /></td>
                <td><c:out value="${tracking.latitude}" /></td>
                <td><c:out value="${tracking.longitude}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${tracking.created}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${tracking.updated}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jspFragments:paging />
<a class="btn waves-effect waves-light right red" href="${pagesTracking}/add"><i class="material-icons">add</i></a>
