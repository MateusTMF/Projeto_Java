<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<h2>veiculo</h2>

<table id="dataTable" class="table table-bordered border-primary">
    <thead>
        <tr>
            <th align="left">ID</th>
            <th align="left">marcaveiculo</th>
            <th align="left">modeloveiculo</th>
            <th align="right"></th>
            <th align="right"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="veiculo" items="${veiculos}">
            <tr>
                <td align="left">${veiculo.idveiculo}</td>
                <td align="left">${veiculo.marcaveiculo}</td>
                <td align="left">${veiculo.modeloveiculo}</td>
                <td align="center"><a href="${pageContext.request.contextPath}/VeiculoExcluir?idveiculo=${veiculo.idveiculo}">Excluir</a></td>
                <td align="center"><a href="${pageContext.request.contextPath}/VeiculoCarregar?idveiculo=${veiculo.idveiculo}">Alterar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div align="center">
    <a href="${pageContext.request.contextPath}/VeiculoNovo">Novo</a>
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