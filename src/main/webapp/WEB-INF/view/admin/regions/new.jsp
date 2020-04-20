<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<h1>Добавление региона</h1>

<br>

<sf:form id="regionForm" class="form-horizontal"
		 modelAttribute="region"
		 action="/admin/regions/new" method="post">

	<tiles:insertAttribute name="form-fields"/>

	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-5">
			<a href="<c:url value="/admin/regions" />" class="btn btn-default">
				Вернуться
			</a>
			<button type="submit" class="btn btn-primary">
				Создать
			</button>
		</div>
	</div>
</sf:form>
