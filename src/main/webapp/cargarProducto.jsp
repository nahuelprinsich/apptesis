<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Nahuel
  Date: 13/1/2018
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carga de producto</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="resources/js/cargarProducto.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.4.1/css/buttons.dataTables.min.css">
    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.flash.min.js"></script>
    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.html5.min.js"></script>
    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.print.min.js"></script>
    <script src="resources/js/dataTables.cellEdit.js"></script>
</head>
<body>
    <div class="container">
            <form class="form-horizontal" id="formularioCarga" action="#">
                <div class="row">
                    <div class="col-md-8 offset-md-2">
                        <div class="form-group">
                            <h1>Producto</h1>
                        </div>
                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="nombreProducto">Nombre:</label>
                            <div class="col-sm-8">
                                <s:textfield name="nombreProducto" id="nombreProducto" class="form-control" placeholder="Aceite de girasol, Shampoo, .." ></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="rubroProducto">Rubro:</label>
                            <div class="col-sm-8">
                                <s:textfield name="rubroProducto" id="rubroProducto" class="form-control" placeholder="Aceite, Azucar, .." ></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="tipoRubroProducto">Tipo Rubro:</label>
                            <div class="col-sm-8">
                                <s:select id="tipoRubroProducto"
                                          headerKey="1"
                                          list="#{'1':'alimentacion', '2':'cosmetica', '3':'limpieza'}"
                                          name="tipoRubroProducto"
                                          class="form-control"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="codigoBarraProducto">Codigo de barra:</label>
                            <div class="col-sm-8">
                                <s:textfield type="number" name="codigoBarraProducto" id="codigoBarraProducto" class="form-control" placeholder="789686321265" ></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="porcionProducto">Porcion:</label>
                            <div class="col-sm-8">
                                <s:textfield type="number" name="porcionProducto" id="porcionProducto" class="form-control" placeholder="300, 13, .." ></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="tipoPorcionProducto">Tipo de porcion:</label>
                            <div class="col-sm-8">
                                <s:select id="tipoPorcionProducto"
                                          headerKey="1"
                                          list="#{'1':'mg', '2':'g', '4':'ml', '5':'l'}"
                                          name="tipoPorcionProducto"
                                          class="form-control"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="marcaProducto">Marca:</label>
                            <div class="col-sm-8">
                                <s:textfield name="marcaProdcuto" id="marcaProducto" class="form-control" placeholder="Natura, Pantene, .." ></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="contenidoNetoProducto">Contenido neto:</label>
                            <div class="col-sm-8">
                                <s:textfield name="contenidoNetoProducto" id="contenidoNetoProducto" class="form-control" placeholder="300g, 900ml, .." ></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="descripcionProducto">Descripcion:</label>
                            <div class="col-sm-8">
                                <s:textarea name="descripcionProducto" id="descripcionProducto" class="form-control"></s:textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="urlImagenProducto">Url Imagen:</label>
                            <div class="col-sm-8">
                                <s:textfield name="urlImagenProducto" id="urlImagenProducto" class="form-control"></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="esAlimentoProducto">Es alimento?:</label>
                            <div class="col-sm-8">
                                <s:checkbox name="esAlimentoProducto" id="esAlimentoProducto" fieldValue="false"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8 offset-md-2">
                        <div class="form-group">
                            <h1>Envase</h1>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="descripcionEnvase">Descripcion:</label>
                            <div class="col-sm-8">
                                <s:textarea name="descripcionEnvase" id="descripcionEnvase" class="form-control" ></s:textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="caracteristicaRetornable">Retornable:</label>
                            <div class="col-sm-8">
                                <s:select id="caracteristicaRetornable"
                                          headerKey="1"
                                          list="#{'1':'Retornable reutilizable', '2':'Retornable reciclable', '3':'Potencialmente retornable', '4':'No retornable'}"
                                          name="tipoPorcionProducto"
                                          class="form-control"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="caracteristicaReutilizable">Reutilizable:</label>
                            <div class="col-sm-8">
                                <s:select id="caracteristicaReutilizable"
                                          headerKey="1"
                                          list="#{'5':'Muy reutilizable', '6':'Poco reutilizable', '7':'No reutilizable o raramente reutilizable'}"
                                          name="tipoPorcionProducto"
                                          class="form-control"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="caracteristicaReciclable">Reciclable:</label>
                            <div class="col-sm-8">
                                <s:select id="caracteristicaReciclable"
                                          headerKey="1"
                                          list="#{'8':'Reciclable facil', '9':'Reciclable dificil', '10':'No reciclable', '11':'Tratamiento especial'}"
                                          name="tipoPorcionProducto"
                                          class="form-control"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="caracteristicaCompostable">Compostable:</label>
                            <div class="col-sm-8">
                                <s:select id="caracteristicaCompostable"
                                          headerKey="1"
                                          list="#{'12':'Compostable', '13':'No compostable'}"
                                          name="tipoPorcionProducto"
                                          class="form-control"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="caracteristicaMP">Materias primas recicladas:</label>
                            <div class="col-sm-8">
                                <s:select id="caracteristicaMP"
                                          headerKey="1"
                                          list="#{'14':'Altamente Recicladas', '15':'Recicladas Parcialmente', '16':'No recicladas'}"
                                          name="tipoPorcionProducto"
                                          class="form-control"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="caracteristicaCO">Certificacion origen materias primas:</label>
                            <div class="col-sm-8">
                                <s:select id="caracteristicaCO"
                                          headerKey="1"
                                          list="#{'17':'Certificada', '18':'No certificada'}"
                                          name="tipoPorcionProducto"
                                          class="form-control"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <hr>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8 offset-md-2">
                        <div class="form-group">
                            <h1>Fabricante</h1>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="razonSocialFabricante">Razon social:</label>
                            <div class="col-sm-8">
                                <s:textfield name="razonSocialFabricante" id="razonSocialFabricante" class="form-control" placeholder="La Serenisima, Sancor, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <hr>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-8 offset-md-2">
                        <div class="form-group">
                            <h1>Usuario</h1>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="nombreUsuario">Nombre:</label>
                            <div class="col-sm-8">
                                <s:textfield name="nombreUsuario" id="nombreUsuario" class="form-control" ></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="apellidoUsuario">Apellido:</label>
                            <div class="col-sm-8">
                                <s:textfield name="apeliidoUsuario" id="apellidoUsuario" class="form-control" ></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <hr>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-8 offset-md-2">
                        <div class="form-group">
                            <h1>Ingredientes</h1>
                        </div>
                        <table id="tablaIngredientes" class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th>Con Advertencia</th>
                                <th>Tipo de Rubro</th>
                            </tr>
                            </thead>
                        </table>
                        <div class="form-group">
                            <hr>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-8 offset-md-2">
                        <div class="form-group">
                            <h1>Valores Energeticos</h1>
                        </div>
                        <table id="tablaValores" class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th>Recomendable Diario</th>
                                <th>Tipo de Porcion</th>
                                <th>Cantidad por porcion</th>
                            </tr>
                            </thead>
                        </table>
                        <div class="form-group">
                            <hr>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-8 offset-md-2">
                        <div class="form-group">
                            <h1>Etiquetas</h1>
                        </div>
                        <table id="tablaExtras" class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Descripcion</th>
                                <th>tipo de Rubro</th>
                            </tr>
                            </thead>
                        </table>
                        <div class="form-group">
                            <hr>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-8 offset-md-2">
                        <div class="form-group">
                            <div class="col-md-1">
                                <s:submit type="button" value="Cargar" onclick="cargaProducto()" class="btn btn-default"/>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

        <!-- Modal Ingrediente-->
        <div id="modalIngrediente" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Ingrediente</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="nombreIngrediente">Nombre:</label>
                            <div class="col-sm-8">
                                <s:textfield name="nombreIngrediente" id="nombreIngrediente" class="form-control" placeholder="Agua, Harina de maiz, .." ></s:textfield>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="descripcionIngrediente">Descripcion:</label>
                            <div class="col-sm-8">
                                <s:textarea name="descripcionIngrediente" id="descripcionIngrediente" class="form-control" placeholder=""></s:textarea>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="linkIngrediente">Link de informacion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="linkIngrediente" id="linkIngrediente" class="form-control"></s:textfield>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="tipoRubroIngrediente">Tipo de Rubro:</label>
                            <div class="col-sm-8">
                                <s:select id="tipoRubroIngrediente"
                                          headerKey="1"
                                          list="#{'1':'alimentacion', '2':'cosmetica', '3':'limpieza'}"
                                          name="tipoRubroIngrediente"
                                          class="form-control"
                                />
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-4">Con advertencia:</label>
                            <div class="col-sm-8">
                                <s:radio id="conAdvertenciaIngrediente" name="conAdvertenciaIngrediente" list="#{'true':'Si','false':'No'}" value="false" />
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <button type="button" class="btn btn-default" onclick="cargarIngrediente()">Cargar</button>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <!-- Modal Valor Energetico-->
        <div id="modalValorEnergetico" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Valor Energetico</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="nombreValorEnergetico">Nombre:</label>
                            <div class="col-sm-8">
                                <s:textfield name="nombreValorEnergetico" id="nombreValorEnergetico" class="form-control" placeholder="Carbohidratos, Proteinas, .." ></s:textfield>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="descripcionValorEnergetico">Descripcion:</label>
                            <div class="col-sm-8">
                                <s:textarea name="descripcion" id="descripcionValorEnergetico" class="form-control" placeholder=""></s:textarea>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="recomendableValorEnergetico">Recomendable diario:</label>
                            <div class="col-sm-8">
                                <s:textfield type="number" name="recomendableValorEnergetico" id="recomendableValorEnergetico" class="form-control" placeholder="2.1, .." ></s:textfield>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="tipoPorcionValorEnergetico">Tipo de porcion:</label>
                            <div class="col-sm-8">
                                <s:select id="tipoPorcionValorEnergetico"
                                          headerKey="1"
                                          list="#{'1':'mg', '2':'g', '4':'ml', '5':'l', '6':'kcal'}"
                                          name="tipoPorcionValorEnergetico"
                                          class="form-control"
                                />
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="linkValorEnergetico">Link de informacion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="linkValorEnergetico" id="linkValorEnergetico" class="form-control"></s:textfield>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <button type="button" class="btn btn-default" onclick="cargarValorEnergetico()">Cargar</button>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <!-- Modal Extra-->
        <div id="modalExtra" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Etiqueta</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="descripcionExtra">Descripcion:</label>
                            <div class="col-sm-8">
                                <s:textarea name="descripcionExtra" id="descripcionExtra" class="form-control" placeholder="Sin TACC, .." ></s:textarea>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="urlLogo">Url de logo:</label>
                            <div class="col-sm-8">
                                <s:textfield name="urlLogo" id="urlLogo" class="form-control"></s:textfield>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="tipoRubroExtra">Tipo de Rubro:</label>
                            <div class="col-sm-8">
                                <s:select id="tipoRubroExtra"
                                          headerKey="1"
                                          list="#{'1':'alimentacion', '2':'cosmetica', '3':'limpieza'}"
                                          name="tipoRubroExtra"
                                          class="form-control"
                                />
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <button type="button" class="btn btn-default" onclick="cargarExtra()">Cargar</button>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>
</body>
</html>
