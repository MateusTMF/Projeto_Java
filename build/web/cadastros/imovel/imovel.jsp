<%--

Esse código é uma página JSP (JavaServer Pages) que exibe uma tabela HTML com dados de imóveis.

A página começa com algumas declarações de taglibs (bibliotecas de tags JSP) para permitir o uso de tags 
como "c:forEach" (para fazer iteração em uma coleção) e "fmt" (para formatar dados).

Em seguida, há duas chamadas para jsp:include, que adicionam o conteúdo de outros arquivos JSP à página. 
Isso é comum em aplicações web para separar a lógica da interface do usuário.

O resto do código é HTML com tags JSP embutidas que permitem a inclusão de expressões Java em partes 
específicas da página. Por exemplo, a tag "c:forEach" itera sobre uma coleção de objetos "imovel" e cria
uma linha na tabela HTML para cada um deles. As expressões Java "${imovel.idimovel}" e "${imovel.bairroimovel}"
são usadas para imprimir o valor dos atributos "idimovel" e "bairroimovel" de cada objeto "imovel" na tabela.

No final da página, há um script jQuery que inicializa um plugin de tabela chamado DataTables, que permite a
classificação e a pesquisa dos dados da tabela. O script também define uma mensagem personalizada para cada 
elemento do plugin em português.


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