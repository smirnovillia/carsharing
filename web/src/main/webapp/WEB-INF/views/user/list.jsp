<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>

<h4 class="header">Customer</h4>
<table class="bordered highlight">
    <tbody>
        <tr>
            <th><mytaglib:sort-link pageUrl="${pagesCustomer}" column="id">id</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesCustomer}" column="firstName">first name</mytaglib:sort-link></th>
             <th><mytaglib:sort-link pageUrl="${pagesCustomer}" column="lastName">last name</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesCustomer}" column="created">created</mytaglib:sort-link></th>
            <th><mytaglib:sort-link pageUrl="${pagesCustomer}" column="updated">updated</mytaglib:sort-link></th>
            <th></th>
        </tr>
        <c:forEach var="customer" items="${gridItems}" varStatus="loopCounter">
            <tr>
                <td><c:out value="${customer.id}" /></td>
                <td><c:out value="${customer.name}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${customer.created}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${customer.updated}" /></td>
                <td class="right"><a class="btn-floating" href="${pagesCustomer}/${customer.id}"><i class="material-icons">info</i></a> <a
                    class="btn-floating" href="${pagesCustomer}/${customer.id}/edit"><i class="material-icons">edit</i></a> <a
                    class="btn-floating red" href="${pagesCustomer}/${customer.id}/delete"><i class="material-icons">delete</i></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jspFragments:paging />