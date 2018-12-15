<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>

<h4 class="header">Colors</h4>
<table class="bordered highlight">
    <tbody>
        <tr>
            <th><mytaglib:sort-link pageUrl="${pagesColor}" column="id">id</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesColor}" column="name">name</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesColor}" column="created">created</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesCOlor}" column="updated">updated</mytaglib:sort-link></th>
            <th></th>
        </tr>
        <c:forEach var="color" items="${gridItems}" varStatus="loopCounter">
            <tr>
                <td><c:out value="${color.id}" /></td>
                <td><c:out value="${color.name}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${color.created}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${color.updated}" /></td>
                <td class="right"><a class="btn-floating" href="${pagesColor}/${color.id}"><i class="material-icons">info</i></a> <a
                    class="btn-floating" href="${pagesColor}/${color.id}/edit"><i class="material-icons">edit</i></a> <a
                    class="btn-floating red" href="${pagesColor}/${color.id}/delete"><i class="material-icons">delete</i></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jspFragments:paging />
<a class="waves-effect waves-light btn right" href="${pagesColor}/add"><i class="material-icons">add</i></a>
