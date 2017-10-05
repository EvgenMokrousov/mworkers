<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="worker">
	<h1>Сведения о трудящихся</h1>
    <form method="get" action="select">
		<label for="date">На дату </label>
		<input id="date" type="date" name="date" /> <br/><br/>
        <label for="find">Трудящийся</label>
		<input id="find" type="text" name="find" size="30"/>
		<!-- <a href="select/Мок">Поиск</a> -->
		<input type="submit" value="Поиск" />
    </form><br/>
	<c:if test="${!empty workerList}">
		<table>
			<tr>
				<th>ФИО</th>
				<th>Тип дня</th>
			</tr>
			<c:forEach var="worker" items="${workerList}">
				<tr>
					<td>${worker.fam} ${worker.imj} ${worker.otch}</td>
                    <td class="trDType">${worker.d_type}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>
