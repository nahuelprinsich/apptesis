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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
            <form action="<s:url action="CargarProducto"/>" class="form-horizontal">
                <div class="row">
                    <div class="col-sm-7">
                        <h1>Producto</h1>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="nombreProducto">Nombre:</label>
                            <div class="col-sm-8">
                                <s:textfield name="producto.nombreProducto" id="nombreProducto" class="form-control" placeholder="Aceite de girasol, Shampoo, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="rubro">Rubro:</label>
                            <div class="col-sm-8">
                                <s:textfield name="producto.rubro" id="rubro" class="form-control" placeholder="Aceite, Azucar, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="codigoBarra">Codigo de barra:</label>
                            <div class="col-sm-8">
                                <s:textfield name="producto.codigoBarra" id="codigoBarra" class="form-control" placeholder="789686321265"></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="porcion">Porcion:</label>
                            <div class="col-sm-8">
                                <s:textfield type="number" name="producto.porcion" id="porcion" class="form-control" placeholder="300, 13, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="tipoPorcion">Tipo de porcion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="producto.tipoPorcion" id="tipoPorcion" class="form-control" placeholder="g, ml, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="marca">Marca:</label>
                            <div class="col-sm-8">
                                <s:textfield name="producto.marca" id="marca" class="form-control" placeholder="Natura, Pantene, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="contenidoNeto">Contenido neto:</label>
                            <div class="col-sm-8">
                                <s:textfield name="producto.contenidoNeto" id="contenidoNeto" class="form-control" placeholder="300g, 900ml, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox name="producto.esAlimento" fieldValue="false" label="Es Alimento?"/>
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
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="nombreIngrediente">Nombre:</label>
                            <div class="col-sm-8">
                                <s:textfield name="ingrediente.nombre" id="nombreIngrediente" class="form-control" placeholder="Agua, Harina de maiz, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="descripcionIngrediente">Descripcion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="ingrediente.descripcion" id="descripcionIngrediente" class="form-control" placeholder=""></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4">Con advertencia:</label>
                            <div class="col-sm-8">
                                <s:radio name="ingrediente.conAdvertencia" list="#{'true':'Si','false':'No'}" value="false" />
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
                                <button type="submit" class="btn btn-default">+</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <button type="submit" class="btn btn-default">-</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-5">
                        <h2 class="escondido">In</h2>
                        <div class="panel panel-primary">
                            <div class="panel-heading">Ingredientes</div>
                            <s:textfield name="buscarIngrediente" id="buscarIngrediente" class="form-control" placeholder="Buscar.."></s:textfield>
                            <select multiple class="form-control" id="selectIngrediente">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Valores Energeticos</h2>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="nombreValor">Nombre:</label>
                            <div class="col-sm-8">
                                <s:textfield name="valorEnergetico.nombre" id="nombreValor" class="form-control" placeholder="Carbohidratos, Proteinas, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="descripcionValor">Descripcion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="valorEnergetico.descripcion" id="descripcionValor" class="form-control" placeholder=""></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="recomendable">Recomendable diario:</label>
                            <div class="col-sm-8">
                                <s:textfield type="number" name="valorEnergetico.recomendableDiario" id="recomendable" class="form-control" placeholder="2.1, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="valor">Valor:</label>
                            <div class="col-sm-8">
                                <s:textfield type="number" name="valorEnergetico.valor" id="valor" class="form-control" placeholder="3.8, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="tipoPorcionValor">Tipo de porcion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="valorEnergetico.tipoPorcion" id="tipoPorcionValor" class="form-control" placeholder="g, mg, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <hr>
                        </div>
                    </div>
                    <div class="col-sm-1">
                        <h2 class="escondido">Va</h2>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <button type="submit" class="btn btn-default">+</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <button type="submit" class="btn btn-default">-</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-5">
                        <h2 class="escondido">Va</h2>
                        <div class="panel panel-primary">
                            <div class="panel-heading">Valores Energeticos</div>
                            <s:textfield name="buscarValor" id="buscarValor" class="form-control" placeholder="Buscar.."></s:textfield>
                            <select multiple class="form-control" id="selectValor">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
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
                                <s:textfield name="envase.tipoEnvase" id="tipoEnvase" class="form-control" placeholder="PET, PEAD, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="descripcionEnvase">Descripcion:</label>
                            <div class="col-sm-8">
                                <s:textfield name="envase.descripcion" id="descripcionEnvase" class="form-control"></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox name="envase.ftalatos" fieldValue="false" label="Posee ftalatos?"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox name="envase.retornable" fieldValue="false" label="Es retornable?"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox name="envase.reutilizable" fieldValue="false" label="Es reutilizable?"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox name="envase.marcado" fieldValue="false" label="Esta marcado?"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox name="envase.reciclable" fieldValue="false" label="Es reciclable?"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <div class="checkbox">
                                    <s:checkbox name="envase.aptoConsumo" fieldValue="false" label="Es apto para el consumo?"/>
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
                            <label class="control-label col-sm-4" for="razonSocial">Razon social:</label>
                            <div class="col-sm-8">
                                <s:textfield name="fabricante.razonSocial" id="razonSocial" class="form-control" placeholder="La Serenisima, Sancor, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="domicilio">Domicilio:</label>
                            <div class="col-sm-8">
                                <s:textfield name="fabricante.domicilio" id="domicilio" class="form-control" placeholder="Calle 1 N° 1234, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="localidad">Localidad:</label>
                            <div class="col-sm-8">
                                <s:textfield name="fabricante.localidad" id="localidad" class="form-control" placeholder="La Plata, Buenos Aires, .."></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="pais">Pais:</label>
                            <div class="col-sm-8">
                                <s:textfield name="fabricante.pais" id="pais" class="form-control" placeholder="Argentina, Brasil, .."></s:textfield>
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
                                <s:textfield name="extra.descripcion" id="descripcionExtra" class="form-control" placeholder="Sin TACC, .."></s:textfield>
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
                                <button type="submit" class="btn btn-default">+</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <button type="submit" class="btn btn-default">-</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-5">
                        <h2 class="escondido">In</h2>
                        <div class="panel panel-primary">
                            <div class="panel-heading">Informacion Extra</div>
                            <s:textfield name="buscarExtra" id="buscarExtra" class="form-control" placeholder="Buscar.."></s:textfield>
                            <select multiple class="form-control" id="selectInformacion">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-5">
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <button type="submit" class="btn btn-default">Cargar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
    </div>
</body>
</html>
