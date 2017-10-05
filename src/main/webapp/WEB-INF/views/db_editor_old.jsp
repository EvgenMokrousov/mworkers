<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div id="editor">
    <script>
        function editWorker(id, f) {
            alert("id = " + id + " "+ f);
        }
    </script>
    <h1>Редактор базы</h1>
    <div id="f_ed">
        <sf:form method="post" modelAttribute="worker">
            <sf:hidden path="id"/>
            <fieldset>
                <legend>Новый трудящийся</legend>
            <table>
                <tr>
                    <td><sf:label path="fam">Фамилия:</sf:label></td>
                    <td><sf:input path="fam" size="30"/><br/>
                        <sf:errors path="fam" cssClass="error" />
                    </td>
                    <td>Табель</td>
                </tr>
                <tr>
                    <td><sf:label path="imj">Имя:</sf:label></td>
                    <td><sf:input path="imj" size="30"/><br/>
                        <sf:errors path="imj" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td><sf:label path="otch">Отчество:</sf:label></td>
                    <td><sf:input path="otch" size="30"/><br/>
                        <sf:errors path="otch" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input name="commit" type="submit" value="Сохранить" />
                    </td>
                </tr>
            </table>
            </fieldset>
        </sf:form>
    </div>
    <div id="tab_ed">
        <sf:form method="post" action="/db_editor/tabel/add" modelAttribute="tabel">
            <sf:input path="d" type="date" />
            <sf:input path="d_type" size="2"/>
            <!---<select path="d_type"><option value="Я">Я</option><option value="В">В</option><option value="К">К</option><option value="Б">Б</option><option value="От">От</option></select>--->
            <input name="commit" type="submit" value="Добавить">
            <sf:hidden path="id"/>
        </sf:form>
    </div>
	<c:if test="${!empty workerList}">
        <div id = "r_ed">
            <table>
                <tr>
                    <th>ФИО</th>
                    <th>ДР</th>
                </tr>
                <c:forEach var="worker" items="${workerList}">
                    <s:url value="db_editor/edit/${worker.id}" var="edit_url" />
                    <tr>
                        <td>${worker.fam}</td>
                        <td>${worker.imj}</td>
                        <td>${worker.otch}</td>
                        <td><fmt:formatDate value="${worker.dbirth}" pattern="dd.MM.yyyy" /> </td>
                        <td><a href="${edit_url}">Править</a></td>
                        <td><a href="db_editor/delete/${worker.id}">Удалить</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
	</c:if>
</div>
