<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@ include file="navbar.jsp" %>

        <h1 align="center">Cadastro de Paciente</h1>
        <hr>
        <h2 align="center">${mensagem}</h2>


        <div class="container">

            <form name="cadastrarpaciente" action="CadastrarPaciente" method="POST">


                <div class="form-row">
                    <div class="form-group col-md-8">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" >
                    </div>
                    <div class="form-group col-md-2">
                        <label for="peso">Peso</label>
                        <input type="text" id="peso" class="form-control" name="peso" >
                    </div>
                    <div class="form-group col-md-2">
                        <label for="tiposanguineo">Tipo Sanguineo</label>
                        <select name="idTipoSanguineo" class="form-control" >
                            <c:forEach var="tiposanguineo" items="${tiposanguineos}">
                                <option value="${tiposanguineo.idTipoSanguineo}">${tiposanguineo.tipoSanguineo}</option>
                            </c:forEach>
                        </select>

                    </div>
                </div>
                <div class="form-group">
                    <label for="endereco">Endereço</label>
                    <input type="text" class="form-control" id="endereco" name="endereco" >
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="cidade">Cidade</label>
                        <input type="text" class="form-control" id="cidade" name="cidade" >
                    </div>
                    <div class="form-group col-md-4">
                        <label for="uf">Estado</label>
                        <select name="idUf" class="form-control" >
                            <c:forEach var="uf" items="${ufs}">
                                <option value="${uf.idUf}">${uf.uf}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="cep">CEP</label>
                        <input type="text" class="cep form-control" id="cep" name="cep" data-mask="00000-000">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Cadastrar</button>

            </form>
        </div>

        <%@include file="footer.jsp" %>

            <%@include file="logoutmodal.jsp" %>

                <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
                <%@include file="scripts.jsp" %>

                    </body>

                    </html>