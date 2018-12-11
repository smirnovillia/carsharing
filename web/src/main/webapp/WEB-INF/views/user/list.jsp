<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>

<h4 class="header">User</h4>
<table class="bordered highlight">
    <tbody>
        <tr>
            <th><mytaglib:sort-link pageUrl="${pagesUser}" column="id">id</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesUser}" column="login">login</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesUser}" column="firstName">first name</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesUser}" column="birthday">last name</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesUser}" column="created">created</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesUser}" column="updated">updated</mytaglib:sort-link></th>
            <th></th>
        </tr>
        <c:forEach var="user" items="${gridItems}" varStatus="loopCounter">
            <tr>
                <td><c:out value="${user.customer.id}" /></td>
                <td><c:out value="${user.login}" /></td>
                <td><c:out value="${user.customer.firstName}" /></td>
                <td><c:out value="${user.customer.lastName}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.customer.birthday}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.customer.created}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.customer.updated}" /></td>
                <td class="right"><a class="btn-floating" href="${pagesUser}/${user.customer.id}"><i class="material-icons">info</i></a> <a
                    class="btn-floating" href="${pagesUser}/${user.customer.id}/edit"><i class="material-icons">edit</i></a> <a
                    class="btn-floating red" href="${pagesUser}/${user.customer.id}/delete"><i class="material-icons">delete</i></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jspFragments:paging />