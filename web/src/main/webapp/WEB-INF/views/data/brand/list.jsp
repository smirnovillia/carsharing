<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>

<h4 class="header">Brands</h4>
<table class="bordered highlight">
    <tbody>
        <tr>
            <th><mytaglib:sort-link pageUrl="${pagesBrand}" column="id">id</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesBrand}" column="name">name</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesBrand}" column="created">created</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesBrand}" column="updated">updated</mytaglib:sort-link></th>
            <th></th>
        </tr>
        <c:forEach var="brand" items="${gridItems}" varStatus="loopCounter">
            <tr>
                <td><c:out value="${brand.id}" /></td>
                <td><c:out value="${brand.name}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${brand.created}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${brand.updated}" /></td>
                <td class="right"><a class="btn-floating" href="${pagesBrand}/${brand.id}"><i class="material-icons">info</i></a> <a
                    class="btn-floating" href="${pagesBrand}/${brand.id}/edit"><i class="material-icons">edit</i></a> <a
                    class="btn-floating red" href="${pagesBrand}/${brand.id}/delete"><i class="material-icons">delete</i></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jspFragments:paging />
<a class="btn waves-effect waves-light right red" href="${pagesBrand}/add"><i class="material-icons">add</i></a>
