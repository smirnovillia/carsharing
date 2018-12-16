<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>

<h4 class="header">Modifications of model ${modelName}</h4>
<table class="bordered highlight">
    <tbody>
        <tr>
            <th>id</th>
            <th>created</th>
            <th>updated</th>
            <th></th>
        </tr>
        <c:forEach var="dto" items="${gridItems}" varStatus="loopCounter">
            <tr>
                <td><c:out value="${dto.id}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.created}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.updated}" /></td>
                <td class="right"><a class="btn-floating" href="${pagesModification}/${dto.id}"><i class="material-icons">info</i></a> <a
                    class="btn-floating" href="${pagesModification}/${dto.id}/edit"><i class="material-icons">edit</i></a> <a
                    class="btn-floating red" href="${pagesModification}/${dto.id}/delete"><i class="material-icons">delete</i></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a class="waves-effect waves-light btn right" href="${pagesModification}/add?modelId=${modelId}"><i class="material-icons">add</i></a>
