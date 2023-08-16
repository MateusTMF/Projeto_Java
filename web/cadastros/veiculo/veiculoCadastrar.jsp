<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarveiculo" action="VeiculoCadastrar" method="POST">
    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center"> Cadastro de Veiculo</th>
            </tr>
            <tr>
                <th colspan="2" align="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ID: </td>
                <td><input type="text" name="idveiculo" id="idveiculo" value="${veiculo.idveiculo}" readonly="readonly" /></td></tr>
            <tr>
                <td>Marca Veiculo: </td>
                <td><input type="text" name="marcaveiculo" id="marcaveiculo" value="${veiculo.marcaveiculo}" size="50" maxlength="50" /></td></tr>
            <tr>
                <td>Modelo Veiculo: </td>
                <td><input type="text" name="modeloveiculo" id="modeloveiculo" value="${veiculo.modeloveiculo}" size="50" maxlength="50" /></td>
            </tr> 
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar" /> 
                    <input type="reset" name="limpar" id="limpar" value="Limpar" />
                </td>
            </tr>
            <tr>        
                <td align="center" colspan="2"><h5><a href="index.jsp">Voltar à Página Inicial</a></h5></td>
            </tr>
        <tBody>
    </table>
</form>
<%@include file="/footer.jsp" %>