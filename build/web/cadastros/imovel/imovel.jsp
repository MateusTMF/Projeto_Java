<%--

Esse c�digo � uma p�gina JSP (JavaServer Pages) que exibe uma tabela HTML com dados de im�veis.

A p�gina come�a com algumas declara��es de taglibs (bibliotecas de tags JSP) para permitir o uso de tags 
como "c:forEach" (para fazer itera��o em uma cole��o) e "fmt" (para formatar dados).

Em seguida, h� duas chamadas para jsp:include, que adicionam o conte�do de outros arquivos JSP � p�gina. 
Isso � comum em aplica��es web para separar a l�gica da interface do usu�rio.

O resto do c�digo � HTML com tags JSP embutidas que permitem a inclus�o de express�es Java em partes 
espec�ficas da p�gina. Por exemplo, a tag "c:forEach" itera sobre uma cole��o de objetos "imovel" e cria
uma linha na tabela HTML para cada um deles. As express�es Java "${imovel.idimovel}" e "${imovel.bairroimovel}"
s�o usadas para imprimir o valor dos atributos "idimovel" e "bairroimovel" de cada objeto "imovel" na tabela.

No final da p�gina, h� um script jQuery que inicializa um plugin de tabela chamado DataTables, que permite a
classifica��o e a pesquisa dos dados da tabela. O script tamb�m define uma mensagem personalizada para cada 
elemento do plugin em portugu�s.


 --%>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<h2>Imovel</h2>

<table id="dataTable" class="table table-bordered border-primary">
    <thead>
        <tr>
            <th align="left">ID</th>
            <th align="left">descricao</th>
            <th align="left">endereco</th>
            <th align="left">valoraluguel</th>
            <th align="right"></th>
            <th align="right"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="imovel" items="${imoveis}">
            <tr>
                <td align="left">${imovel.idimovel}</td>
                <td align="left">${imovel.descricao}</td>
                <td align="left">${imovel.endereco}</td>
                <td align="left">${imovel.valoraluguel}</td>
                <td align="center"><a href="${pageContext.request.contextPath}/imovelExcluir?idimovel=${imovel.idimovel}">Excluir</a></td>
                <td align="center"><a href="${pageContext.request.contextPath}/imovelCarregar?idimovel=${imovel.idimovel}">Alterar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div align="center">
    <a href="${pageContext.request.contextPath}/ImovelNovo">Novo</a>
    <a href="index.jsp">Voltar � pagina Inicial</a>
</div>
<script>
    $(document).ready(function () {
        console.log('entrei ready');
        $('#dataTable').DataTable({
            "oLanguage": {
                "sProcessing": "processando...",
                "sLengthMenu": "mostrar _MENU_ registros",
                "sZeroRecords": "nenhum registro encontrado.",
                "sInfo": "Mostrando de _START_ at� _END_ de _TOTAL_ registros",
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