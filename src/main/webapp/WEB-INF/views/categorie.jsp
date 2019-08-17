<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<div id="formCat">
	<f:form modelAttribute="categorie" action="saveCat" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID Catégorie</td>
				<td><f:input path="idCategorie"/></td>
				<td><f:errors path="idCategorie" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Nom Catégorie</td>
				<td><f:input path="nomCategorie"/></td>
				<td><f:errors path="nomCategorie" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><f:textarea path="description"/></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Photo</td>
				<td><input type="file" name="file"/></td>
				<td></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Save"/>
				</td>
			</tr>
		</table>
	</f:form>
</div>

<div id="">
	<table>
		<tr>
			<th>ID</th>
			<th>Nom Catégorie</th>
			<th>Description</th>
			<th>Photo</th>
		</tr>
		<c:forEach items="${categories }" var="cat">
			<tr>
				<td>${cat.idCategorie }</td>
				<td>${cat.nomCategorie }</td>
				<td>${cat.description }</td>
				<td><img src="photoCat?idCat=${cat.idCategorie }"></td>
			</tr>
		</c:forEach>
	</table>
</div>