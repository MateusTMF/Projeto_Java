<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<h2>Estados</h2>

<table id="dataTable" class="table table-bordered border-primary">
    <thead>
        <tr>
            <th align="left">ID</th>
            <th align="left">Nome Estado</th>
            <th align="left">Sigla Estado</th>
            <th align="right"></th>
            <th align="right"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="estado" items="${estados}">
            <tr>
                <td align="left">${estado.idestado}</td>
                <td align="left">${estado.nomestado}</td>
                <td align="left">${estado.siglaestado}</td>
                <td align="center"><a href="${pageContext.request.contextPath}/EstadoExcluir?idestado=${estado.idestado}">Excluir</a></td>
                <td align="center"><a href="${pageContext.request.contextPath}/EstadoCarregar?idestado=${estado.idestado}">Alterar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div align="center">
    <a href="${pageContext.request.contextPath}/EstadoNovo">Novo</a>
    <a href="index.jsp">Voltar à pagina Inicial</a>
</div>
<script>
    $(document).ready(function () {
        console.log('entrei ready');
        $('#dataTable').DataTable({
            "oLanguage": {
                "sProcessing": "processando...",
                "sLengthMenu": "mostrar _MENU_ registros",
                "sZeroRecords": "nenhum registro encontrado.",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                "sInfoEmpty": "mostrando de 0 ate 0 de 0 registros ",
                "sInfoFiltered": "",
                "sInfoPostFix": "",
                "sSearch": "",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "Primeiro",
                    "sPrevious": "Anterior",
                    "sNext": "Seguinte",
                    "sLast": "Ultimo"
                }
            }
        });
    });
</script>