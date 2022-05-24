<%@page import="br.com.projetopaciente.model.Paciente" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="navbar.jsp" %>
<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<h1 align="center"> Listar Pacientes </h1>
<hr>



<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Busca de pacientes</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Endereco</th>
                            <th>Cidade</th>
                            <th>UF</th>
                            <th></th>

                        </tr>
                    </thead>                    
                    <tbody>
                        <% List<Paciente> pacientes = (List<Paciente>)
                                request.getAttribute("pacientes");
                                for (Paciente paciente : pacientes) {
                        %>
                        <tr>


                            <td align="center">
                                <%=paciente.getNome()%>
                            </td>
                            <td align="center">
                                <%=paciente.getEndereco().getEndereco()%>
                            </td>
                            <td align="center">
                                <%=paciente.getEndereco().getCidade()%>
                            </td>
                            <td align="center">
                                <%=paciente.getEndereco().getUf().getUf()%>
                            </td>
                            <td align="center">
                                <a href="CarregarPaciente?idPaciente=<%=paciente.getIdPaciente()%>">
                                    <i class="fas fa-edit"></i>
                                </a>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->


<%@include file="footer.jsp" %>

<%@include file="logoutmodal.jsp" %>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>

</body>

</html>