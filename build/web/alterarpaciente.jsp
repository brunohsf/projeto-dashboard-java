<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="navbar.jsp" %>

<h1 align="center">Cadastro de Paciente</h1>
<hr>
<h2 align="center">${mensagem}</h2>


<div class="container">

    <form name="alteraraciente" action="AlterarPaciente" method="POST" class="needs-validation" novalidate>


        <div class="form-row">
            <div class="form-group col-md-8">
                <label for="nome">Nome</label>
                <input type="text" class="form-control" id="nome" name="nome" required value="${paciente.nome}">
                <div class="invalid-feedback">
                    Por favor, informe um nome.
                </div>
            </div>
            <div class="form-group col-md-2">
                <label for="peso">Peso</label>
                <input type="text" id="peso" class="form-control" name="peso" required value="${paciente.peso}">
                <div class="invalid-feedback">
                    Por favor, informe o peso.
                </div>
            </div>
            <div class="form-group col-md-2">
                <label for="tiposanguineo">Tipo Sanguineo</label>
                <select name="idTipoSanguineo" class="form-control" required value="${paciente.tipoSanguineo.idTipoSanguineo}">
                    <option selcted value="${paciente.tipoSanguineo.idTipoSanguineo}">${paciente.tipoSanguineo.tipoSanguineo}</option>
                    <c:forEach var="tiposanguineo" items="${tiposanguineos}">
                        <option value="${tiposanguineo.idTipoSanguineo}">${tiposanguineo.tipoSanguineo}</option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Por favor, informe o tipo sanguíneo.
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="endereco">Endereço</label>
            <input type="text" class="form-control" id="endereco" name="endereco" required value="${paciente.endereco.endereco}">
            <div class="invalid-feedback">
                Por favor, informe o endereço.
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="cidade">Cidade</label>
                <input type="text" class="form-control" id="cidade" name="cidade" required value="${paciente.endereco.cidade}">
                <div class="invalid-feedback">
                    Por favor, informe a cidade.
                </div>
            </div>
            <div class="form-group col-md-4">
                <label for="uf">Estado</label>
                <select name="idUf" class="form-control" required>           
                    <option selected value="${paciente.endereco.uf.idUf}">${paciente.endereco.uf.uf}</option>
                    <c:forEach var="uf" items="${ufs}">                        
                        <option value="${uf.idUf}">${uf.uf}</option>                        
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Por favor, informe um Estado.
                </div>
            </div>
            <div class="form-group col-md-2">
                <label for="cep">CEP</label>
                <input type="text" class="cep form-control" id="cep" name="cep" required value="${paciente.endereco.cep}">
                <div class="invalid-feedback">
                    Por favor, informe um CEP.
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Cadastrar</button>

    </form>

    <script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict';
            window.addEventListener('load', function () {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>

</div>

<%@include file="footer.jsp" %>

<%@include file="logoutmodal.jsp" %>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<%@include file="scripts.jsp" %>

<script type="text/javascript" src="./js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="./js/jquery.maskedinput-1.1.4.pack.js"></script>
<script type="text/javascript">
        $(document).ready(function () {
            $("#cep").mask("99.999-999");
        });
</script>



</body>

</html>