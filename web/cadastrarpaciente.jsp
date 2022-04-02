<%@page contentType="text/html" pageEncoding="iso-8859-1" %>

    <%@ include file="navbar.jsp" %>

        <h1 align="center">Cadastro de Paciente</h1>
        <hr>
        <h2 align="center">${mensagem}</h2>


        <div class="container">

            <form name="cadastrarpaciente" action="CadastrarPaciente" method="POST">


                <div class="form-row">
                    <div class="form-group col-md-8">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" required>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="peso">Peso</label>
                        <input type="text" id="peso" class="form-control" name="peso" required>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="tiposanguineo">Tipo Sanguineo</label>
                        <input type="text" id="tiposanguineo" class="form-control" name="tiposanguineo" required>

                    </div>
                </div>
                <div class="form-group">
                    <label for="enderecp">Endereço</label>
                    <input type="text" class="form-control" id="endereco" name="endereco" required>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="cidade">Cidade</label>
                        <input type="text" class="form-control" id="cidade" name="cidade" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="uf">Estado</label>
                        <input type="text" id="uf" class="form-control" name="uf" required>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="cep">CEP</label>
                        <input type="text" class="form-control" id="cep" name="cep" required>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Cadastrar</button>

            </form>
        </div>

        <%@include file="footer.jsp" %>

            <%@include file="logoutmodal.jsp" %>

                <%@include file="scripts.jsp" %>

                    </body>

                    </html>