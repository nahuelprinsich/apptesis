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
</head>
<body>
    <div class="container">
            <form class="form-horizontal" id="formularioCarga" action="#">
                <div class="row">
                    <div class="col-sm-7">
                        <h1>Producto</h1>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="nombreProducto">Nombre:</label>
                            <div class="col-sm-8">
                                <s:textfield name="nombreProducto" id="nombreProducto" class="form-control" placeholder="Aceite de girasol, Shampoo, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="rubroProducto">Rubro:</label>
                            <div class="col-sm-8">
                                <s:textfield name="rubroProducto" id="rubroProducto" class="form-control" placeholder="Aceite, Azucar, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="codigoBarraProducto">Codigo de barra:</label>
                            <div class="col-sm-8">
                                <s:textfield name="codigoBarraProducto" id="codigoBarraProducto" class="form-control" placeholder="789686321265"></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="porcionProducto">Porcion:</label>
                            <div class="col-sm-8">
                                <s:textfield type="number" name="porcionProducto" id="porcionProducto" class="form-control" placeholder="300, 13, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="tipoPorcionProducto">Tipo de porcion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="tipoPorcionProducto" id="tipoPorcionProducto" class="form-control" placeholder="g, ml, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="marcaProducto">Marca:</label>
                            <div class="col-sm-8">
                                <s:textfield name="marcaProdcuto" id="marcaProducto" class="form-control" placeholder="Natura, Pantene, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="contenidoNetoProducto">Contenido neto:</label>
                            <div class="col-sm-8">
                                <s:textfield name="contenidoNetoProducto" id="contenidoNetoProducto" class="form-control" placeholder="300g, 900ml, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox name="esAlimentoProducto" id="esAlimentoProducto" fieldValue="false" label="Es Alimento?"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <hr>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Ingredientes</h2>
                        <!--
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="nombreIngrediente">Nombre:</label>
                            <div class="col-sm-8">
                                <s:textfield name="nombreIngrediente" id="nombreIngrediente" class="form-control" placeholder="Agua, Harina de maiz, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="descripcionIngrediente">Descripcion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="descripcionIngrediente" id="descripcionIngrediente" class="form-control" placeholder=""></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4">Con advertencia:</label>
                            <div class="col-sm-8">
                                <s:radio id="conAdvertenciaIngrediente" name="conAdvertenciaIngrediente" list="#{'true':'Si','false':'No'}" value="false" />
                            </div>
                        </div>
                        <div class="form-group">
                            <hr>
                        </div>
                        -->
                    </div>
                    <!--
                    <div class="col-sm-1">
                        <h2 class="escondido">In</h2>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <button type="button" class="btn btn-default" onclick="agregarIngrediente()">+</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <button type="button" class="btn btn-default" onclick="quitarIngrediente()">-</button>
                            </div>
                        </div>
                    </div>
                    -->
                    <div class="col-md-10 col-md-offset-1">
                        <!--<h2 class="escondido">In</h2>-->
                        <div class="panel panel-primary">
                            <div class="panel-heading">Ingredientes</div>
                            <div class="row">
                                <div class="col-md-11">
                                    <s:textfield name="buscarIngrediente" id="buscarIngrediente" class="form-control" placeholder="Buscar.." onkeyup="buscarIngredientes()"></s:textfield>
                                </div>
                                <div class="col-md-1">
                                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">+</button>
                                </div>
                            </div>
                            <select multiple class="form-control" id="selectIngrediente">
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Valores Energeticos</h2>
                        <!--
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="nombreValorEnergetico">Nombre:</label>
                            <div class="col-sm-8">
                                <s:textfield name="nombreValorEnergetico" id="nombreValorEnergetico" class="form-control" placeholder="Carbohidratos, Proteinas, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="descripcionValorEnergetico">Descripcion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="descripcion" id="descripcionValorEnergetico" class="form-control" placeholder=""></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="recomendableValorEnergetico">Recomendable diario:</label>
                            <div class="col-sm-8">
                                <s:textfield type="number" name="recomendableDiario" id="recomendableValorEnergetico" class="form-control" placeholder="2.1, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="valorValorEnergetico">Valor:</label>
                            <div class="col-sm-8">
                                <s:textfield type="number" name="valor" id="valorValorEnergetico" class="form-control" placeholder="3.8, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="tipoPorcionValorEnergetico">Tipo de porcion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="tipoPorcion" id="tipoPorcionValorEnergetico" class="form-control" placeholder="g, mg, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <hr>
                        </div>-->
                    </div>
                    <!--
                    <div class="col-sm-1">
                        <h2 class="escondido">Va</h2>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <button type="button" class="btn btn-default" onclick="agregarValorEnergetico()">+</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <button type="button" class="btn btn-default" onclick="quitarValorEnergetico()">-</button>
                            </div>
                        </div>
                    </div>-->
                    <div class="col-md-10 col-md-offset-1">
                        <!--<h2 class="escondido">Va</h2>-->
                        <div class="panel panel-primary">
                            <div class="panel-heading">Valores Energeticos</div>
                            <div class="col-sm-10">
                                <s:textfield name="buscarValor" id="buscarValor" class="form-control" placeholder="Buscar.."></s:textfield>
                            </div>
                            <div class="col-sm-2">
                                <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">+</button>
                            </div>
                            <select multiple class="form-control" id="selectValor">
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-7">
                        <h2>Envase</h2>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="tipoEnvase">Tipo:</label>
                            <div class="col-sm-8">
                                <s:textfield name="tipoEnvase" id="tipoEnvase" class="form-control" placeholder="PET, PEAD, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="descripcionEnvase">Descripcion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="descripcionEnvase" id="descripcionEnvase" class="form-control"></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox id="ftalatosEnvase" name="ftalatosEnvase" fieldValue="false" label="Posee ftalatos?"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox id="retornableEnvase" name="retornableEnvase" fieldValue="false" label="Es retornable?"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox id="reutilizableEnvase" name="reutilizableEnvase" fieldValue="false" label="Es reutilizable?"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox id="marcadoEnvase" name="marcadoEnvase" fieldValue="false" label="Esta marcado?"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox id="reciclableEnvase" name="reciclableEnvase" fieldValue="false" label="Es reciclable?"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox id="aptoConsumoEnvase" name="aptoConsumoEnvase" fieldValue="false" label="Es apto para el consumo?"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <hr>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-7">
                        <h2>Fabricante</h2>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="razonSocialFabricante">Razon social:</label>
                            <div class="col-sm-8">
                                <s:textfield name="razonSocialFabricante" id="razonSocialFabricante" class="form-control" placeholder="La Serenisima, Sancor, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="domicilioFabricante">Domicilio:</label>
                            <div class="col-sm-8">
                                <s:textfield name="domicilioFabricante" id="domicilioFabricante" class="form-control" placeholder="Calle 1 N° 1234, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="localidadFabricante">Localidad:</label>
                            <div class="col-sm-8">
                                <s:textfield name="localidadFabricante" id="localidadFabricante" class="form-control" placeholder="La Plata, Buenos Aires, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="paisFabricante">Pais:</label>
                            <div class="col-sm-8">
                                <s:textfield name="paisFabricante" id="paisFabricante" class="form-control" placeholder="Argentina, Brasil, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <hr>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Informacion extra</h2>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="descripcionExtra">Descripcion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="descripcionExtra" id="descripcionExtra" class="form-control" placeholder="Sin TACC, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <hr>
                        </div>
                    </div>
                    <div class="col-sm-1">
                        <h2 class="escondido">In</h2>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <button type="button" class="btn btn-default" onclick="agregarInformacionExtra()">+</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <button type="button" class="btn btn-default" onclick="quitarInformacionExtra()">-</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-5">
                        <h2 class="escondido">In</h2>
                        <div class="panel panel-primary">
                            <div class="panel-heading">Informacion Extra</div>
                            <s:textfield name="buscarExtra" id="buscarExtra" class="form-control" placeholder="Buscar.."></s:textfield>
                            <select multiple class="form-control" id="selectInformacion">
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-5">
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <s:submit type="button" value="Cargar" onclick="cargaProducto()" class="btn btn-default"/>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

        <!-- Modal -->
        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Modal Header</h4>
                    </div>
                    <div class="modal-body">
                        <p>Some text in the modal.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
