(function(t){function e(e){for(var r,s,i=e[0],l=e[1],c=e[2],d=0,m=[];d<i.length;d++)s=i[d],Object.prototype.hasOwnProperty.call(o,s)&&o[s]&&m.push(o[s][0]),o[s]=0;for(r in l)Object.prototype.hasOwnProperty.call(l,r)&&(t[r]=l[r]);u&&u(e);while(m.length)m.shift()();return n.push.apply(n,c||[]),a()}function a(){for(var t,e=0;e<n.length;e++){for(var a=n[e],r=!0,i=1;i<a.length;i++){var l=a[i];0!==o[l]&&(r=!1)}r&&(n.splice(e--,1),t=s(s.s=a[0]))}return t}var r={},o={app:0},n=[];function s(e){if(r[e])return r[e].exports;var a=r[e]={i:e,l:!1,exports:{}};return t[e].call(a.exports,a,a.exports,s),a.l=!0,a.exports}s.m=t,s.c=r,s.d=function(t,e,a){s.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:a})},s.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},s.t=function(t,e){if(1&e&&(t=s(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var a=Object.create(null);if(s.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)s.d(a,r,function(e){return t[e]}.bind(null,r));return a},s.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return s.d(e,"a",e),e},s.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},s.p="/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],l=i.push.bind(i);i.push=e,i=i.slice();for(var c=0;c<i.length;c++)e(i[c]);var u=l;n.push([0,"chunk-vendors"]),a()})({0:function(t,e,a){t.exports=a("56d7")},"04d8":function(t,e,a){},2165:function(t,e,a){"use strict";var r=a("a3c8"),o=a.n(r);o.a},"2a74":function(t,e,a){},"3ef2":function(t,e,a){"use strict";var r=a("c032"),o=a.n(r);e["default"]=o.a},"56d7":function(t,e,a){"use strict";a.r(e);a("cadf"),a("551c"),a("f751"),a("097d");var r=a("2b0e"),o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"app"}},[a("router-view")],1)},n=[],s={name:"app",components:{}},i=s,l=(a("5c0b"),a("2877")),c=Object(l["a"])(i,o,n,!1,null,null,null),u=c.exports,d=a("2f62");r["default"].use(d["a"]);var m=new d["a"].Store({state:{},mutations:{},actions:{}}),f=a("5f5b"),b=(a("f9e3"),a("2dd8"),a("8c4f")),p=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-container",{staticClass:"text-left"},[a("b-row",[a("b-col",{attrs:{cols:"4"}}),a("b-col",{attrs:{cols:"4"}},[a("b-card",{staticClass:"mb-2",staticStyle:{"max-width":"20rem"},attrs:{title:"","img-src":t.logo(),"img-alt":"Image","img-top":"",tag:"article"}},[a("b-card-text",[t.show?a("b-form",{on:{submit:t.onSubmit}},[a("b-form-group",{attrs:{id:"input-group-1",label:"ID:","label-for":"input-1",description:""}},[a("b-form-input",{attrs:{id:"input-1",type:"number",required:"",placeholder:""},model:{value:t.form.email,callback:function(e){t.$set(t.form,"email",e)},expression:"form.email"}})],1),a("b-form-group",{attrs:{id:"input-group-2",label:"Contraseña:","label-for":"input-2"}},[a("b-form-input",{attrs:{id:"input-2",required:"",placeholder:"",type:"password"},model:{value:t.form.contra,callback:function(e){t.$set(t.form,"contra",e)},expression:"form.contra"}})],1),a("div",{staticClass:"text-center"},[a("b-button",{attrs:{type:"submit",variant:"success"}},[t._v("Entrar")])],1),a("p"),a("div",{staticClass:"text-center"},[a("b-alert",{attrs:{show:t.dismissCountDown,dismissible:"",fade:"",variant:"warning"},on:{"dismiss-count-down":t.countDownChanged}},[t._v("\n                Espera "+t._s(t.dismissCountDown)+" segudos...\n            ")])],1)],1):t._e()],1)],1)],1),a("b-col",{attrs:{cols:"4"}})],1)],1)],1)},h=[],v={data:function(){return{form:{email:"",contra:""},show:!0,dismissSecs:5,dismissCountDown:0,showDismissibleAlert:!1}},methods:{onSubmit:function(t){t.preventDefault(),this.showAlert()},onReset:function(t){var e=this;t.preventDefault(),this.form.email="",this.form.nombre="",this.show=!1,this.$nextTick((function(){e.show=!0}))},logo:function(){return a("8a0b")},countDownChanged:function(t){if(this.dismissCountDown=t,0===this.dismissCountDown){var e=JSON.stringify(this.form);this.validaUsr(e)}},showAlert:function(){this.dismissCountDown=this.dismissSecs},validaUsr:function(){this.$router.push("/masterUsr")}}},x=v,g=Object(l["a"])(x,p,h,!1,null,null,null),w=g.exports,C=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-modal",{attrs:{id:"modal-1",title:"CAMBIAR CONTRASEÑA","hide-footer":""}},[a("cambioMiPass")],1),a("header-page",{attrs:{items:t.items}}),a("b-card",{attrs:{"no-body":""}},[a("b-tabs",{attrs:{card:"",vertical:""}},[a("b-tab",{attrs:{title:"Entrenar Bot",active:"","title-item-class":"tab-title-class-left"}},[a("b-card-text",[a("masterEntrenador")],1)],1),a("b-tab",{attrs:{title:"Cambiar Mi Contraseña","title-item-class":"tab-title-class-left"},on:{click:function(e){return t.$bvModal.show("modal-1")}}}),a("b-tab",{attrs:{title:"Salir del Sistema","title-item-class":"tab-title-class-left"},on:{click:t.salir}},[a("b-card-text",[t._v("Salir del Sistema")])],1)],1)],1)],1)},_=[],E=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t.show?a("b-form",{on:{submit:t.onSubmit}},[a("b-form-group",{attrs:{id:"input-group-1",label:"Nueva Contraseña:","label-for":"input-1",description:""}},[a("b-form-input",{attrs:{id:"input-1",type:"password",required:"",placeholder:""},model:{value:t.form.contra1,callback:function(e){t.$set(t.form,"contra1",e)},expression:"form.contra1"}})],1),a("b-form-group",{attrs:{id:"input-group-2",label:"Confirmar Contraseña:","label-for":"input-2"}},[a("b-form-input",{attrs:{id:"input-2",type:"password",required:"",placeholder:""},model:{value:t.form.contra2,callback:function(e){t.$set(t.form,"contra2",e)},expression:"form.contra2"}})],1),a("b-container",{staticClass:"bv-example-row"},[a("b-row",[a("b-col",{attrs:{cols:"6"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{attrs:{type:"submit",variant:"success"}},[t._v("Actualizar")])],1),a("b-col",{attrs:{cols:"1"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{on:{click:function(e){return t.$bvModal.hide("modal-contra")}}},[t._v("Cancelar")])],1)],1)],1)],1):t._e()],1)},k=[],$={data:function(){return{form:{contra1:"",contra2:""},show:!0}},methods:{onSubmit:function(t){t.preventDefault(),this.showConfirm()},onReset:function(t){var e=this;t.preventDefault(),this.form.contra1="",this.form.contra2="",this.show=!1,this.$nextTick((function(){e.show=!0}))},showConfirm:function(){var t=this;this.$bvModal.msgBoxOk("Datos enviados correctamente",{title:"Confirmación",size:"sm",buttonSize:"sm",okVariant:"success",headerClass:"p-2 border-bottom-0",footerClass:"p-2 border-top-0",centered:!0}).then((function(e){t.$bvModal.hide("modal-contra")})).catch((function(t){}))}}},A=$,y=Object(l["a"])(A,E,k,!1,null,null,null),D=y.exports,S=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("b-container",{staticClass:"bv-example-row"},[r("b-row",{staticClass:"text-center"},[r("b-col",{attrs:{cols:"4"}},[r("img",{staticClass:"text-left",attrs:{src:a("8a0b"),width:"100%"}})]),r("b-col",{attrs:{cols:"4"}}),r("b-col",{staticClass:"full-right",attrs:{cols:"4"}},[r("b-card-group",{attrs:{deck:""}},[r("b-card",{attrs:{title:"","header-tag":"header"},scopedSlots:t._u([{key:"header",fn:function(){return[r("h6",{staticClass:"mb-0"},[t._v(t._s(t.items.Perfil))])]},proxy:!0}])},[r("b-card-text",[t._v("\n        "+t._s(t.items.ID)+"-\n        "+t._s(t.items.Nombre)+"\n      ")])],1)],1)],1)],1)],1),r("p")],1)},O=[],R={props:["items"]},M=R,P=Object(l["a"])(M,S,O,!1,null,null,null),I=P.exports,j=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("menuEntrena"),a("router-view")],1)},T=[],z=a("c348"),N={components:{menuEntrena:z["default"]}},F=N,U=Object(l["a"])(F,j,T,!1,null,null,null),B=U.exports,q={components:{cambioMiPass:D,headerPage:I,masterEntrenador:B},methods:{salir:function(){this.$router.push("/")}},data:function(){return{items:{Nombre:"Gustavo A. Arellano",ID:"12345",Perfil:"Entrenador"}}}},L=q,G=(a("7eea"),Object(l["a"])(L,C,_,!1,null,null,null)),J=G.exports,V=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-modal",{attrs:{id:"modal-contra",title:"CAMBIAR CONTRASEÑA","hide-footer":""}},[a("cambioMiPass")],1),a("b-modal",{attrs:{id:"modal-usr-alta",title:"ALTA USUARIO","hide-footer":""}},[a("modalusr")],1),a("b-modal",{attrs:{id:"modal-area-alta",title:"ALTA ÁREA","hide-footer":""}},[a("modalarea")],1),a("b-modal",{attrs:{id:"modal-perfil-alta",title:"ALTA PERFIL","hide-footer":""}},[a("modalPerfil")],1),a("header-page",{attrs:{items:t.items}}),a("b-card",{attrs:{"no-body":""}},[a("b-tabs",{attrs:{card:"",vertical:""}},[a("b-tab",{attrs:{title:"Usuarios",active:"","title-item-class":"tab-title-class-left"}},[a("b-card-text",[a("gridCatUsr"),a("b-button",{directives:[{name:"b-modal",rawName:"v-b-modal.modal-usr-alta",modifiers:{"modal-usr-alta":!0}}],attrs:{variant:"success"}},[t._v("Agregar Usuario")])],1)],1),a("b-tab",{attrs:{title:"Areas","title-item-class":"tab-title-class-left"}},[a("b-card-text",[a("gridCatArea"),a("b-button",{directives:[{name:"b-modal",rawName:"v-b-modal.modal-area-alta",modifiers:{"modal-area-alta":!0}}],attrs:{variant:"success"}},[t._v("Agregar Área")])],1)],1),a("b-tab",{attrs:{title:"Perfiles","title-item-class":"tab-title-class-left"}},[a("b-card-text",[a("gridPerfil"),a("b-button",{directives:[{name:"b-modal",rawName:"v-b-modal.modal-perfil-alta",modifiers:{"modal-perfil-alta":!0}}],attrs:{variant:"success"}},[t._v("Agregar Perfil")])],1)],1),a("b-tab",{attrs:{title:"Cambiar Mi Contraseña","title-item-class":"tab-title-class-left"},on:{click:function(e){return t.$bvModal.show("modal-contra")}}}),a("b-tab",{attrs:{title:"Salir del Sistema","title-item-class":"tab-title-class-left"},on:{click:t.salir}},[a("b-card-text",[t._v("Salir del Sistema")])],1)],1)],1)],1)},H=[],K=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-modal",{attrs:{id:t.infoModal.id,title:"EDITAR USUARIO","ok-only":"","hide-footer":""}},[a("modalUsrEditar")],1),a("b-container",{attrs:{fluid:""}},[a("b-table",{attrs:{bordered:"","show-empty":"",small:"","head-variant":"light",items:t.items,fields:t.fields},scopedSlots:t._u([{key:"cell(editar)",fn:function(e){return[a("b-button",{staticClass:"mr-1",attrs:{size:"sm"},on:{click:function(a){return t.info(e.item,e.index,a.target)}}},[t._v("\n      Editar\n    ")])]}},{key:"cell(enviarliga)",fn:function(e){return[a("b-button",{staticClass:"mr-1",attrs:{size:"sm"},on:{click:function(e){return t.showConfirm()}}},[t._v("\n      Enviar\n    ")])]}}])})],1)],1)},Q=[],W=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t.show?a("b-form",{on:{submit:t.onSubmit}},[a("b-table",{attrs:{fixed:"",small:"",items:t.items,"thead-class":"hidden_header"}}),a("b-form-group",{attrs:{id:"input-group-3",label:"Area:","label-for":"input-3"}},[a("b-form-select",{attrs:{id:"input-3",options:t.area,required:""},model:{value:t.form.area,callback:function(e){t.$set(t.form,"area",e)},expression:"form.area"}})],1),a("b-form-group",{attrs:{id:"input-group-4",label:"Perfil:","label-for":"input-4"}},[a("b-form-select",{attrs:{id:"input-4",options:t.perfil,required:""},model:{value:t.form.perfil,callback:function(e){t.$set(t.form,"perfil",e)},expression:"form.perfil"}})],1),a("b-form-checkbox",{attrs:{id:"checkbox-1",name:"checkbox-1",value:"accepted","unchecked-value":"not_accepted"},model:{value:t.checaEstatus,callback:function(e){t.checaEstatus=e},expression:"checaEstatus"}},[t._v("\n  Activo\n")]),a("p"),a("b-container",{staticClass:"bv-example-row"},[a("b-row",[a("b-col",{attrs:{cols:"6"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{attrs:{type:"submit",variant:"success"}},[t._v("Actualizar")])],1),a("b-col",{attrs:{cols:"1"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{on:{click:function(e){return t.$bvModal.hide("modal-0")}}},[t._v("Cancelar")])],1)],1)],1)],1):t._e()],1)},X=[],Y={data:function(){return{form:{area:null,perfil:null},area:[{text:"Seleccionar Área",value:null},"Area 1","Area 2","Area 3","Area 4"],perfil:[{text:"Seleccionar Perfil",value:null},"Perfil 1","Perfil 2","Perfil 3","Perfil 4"],show:!0,checaEstatus:[],items:[{campo:"ID",valor:"12345"},{campo:"Nombre",valor:"Larsen"},{campo:"Apellido Paterno",valor:"Geneva"},{campo:"Apellido Materno",valor:"Jami"},{campo:"Correo Electrónico",valor:"correo@correo.com"}]}},methods:{onSubmit:function(t){t.preventDefault(),this.showConfirm()},onReset:function(t){var e=this;t.preventDefault(),this.show=!1,this.$nextTick((function(){e.show=!0}))},showConfirm:function(){var t=this;this.$bvModal.msgBoxOk("Datos enviados correctamente",{title:"Confirmación",size:"sm",buttonSize:"sm",okVariant:"success",headerClass:"p-2 border-bottom-0",footerClass:"p-2 border-top-0",centered:!0}).then((function(e){t.$bvModal.hide("modal-0")})).catch((function(t){}))}}},Z=Y,tt=(a("728f"),Object(l["a"])(Z,W,X,!1,null,null,null)),et=tt.exports,at={components:{modalUsrEditar:et},data:function(){return{items:[{ID:12341,nombre:"Nombre 1",area:"Area 1",CORREO:"correo1@correo.com"},{ID:12342,nombre:"Nombre 2",area:"Area 2",CORREO:"correo2@correo.com"},{ID:12343,nombre:"Nombre 3",area:"Area 3",CORREO:"correo3@correo.com"},{ID:12344,nombre:"Nombre 4",area:"Area 4",CORREO:"correo4@correo.com"}],fields:[{key:"ID",label:"ID "},{key:"nombre",label:"Nombre"},{key:"area",label:"Area"},{key:"CORREO",label:"Correo Electrónico"},{key:"editar",label:"Editar"},{key:"enviarliga",label:"Enviar Liga"}],infoModal:{id:"modal-0",title:"",content:""}}},methods:{info:function(t,e,a){this.infoModal.title="Row index: ".concat(e),this.infoModal.content=JSON.stringify(t,null,2),this.$root.$emit("bv::show::modal",this.infoModal.id,a)},showConfirm:function(){this.$bvModal.msgBoxOk("Datos enviados correctamente",{title:"Confirmación",size:"sm",buttonSize:"sm",okVariant:"success",headerClass:"p-2 border-bottom-0",footerClass:"p-2 border-top-0",centered:!0}).then((function(t){})).catch((function(t){}))}}},rt=at,ot=Object(l["a"])(rt,K,Q,!1,null,null,null),nt=ot.exports,st=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-modal",{attrs:{id:t.infoModalarea.id,title:"EDITAR ÁREA","ok-only":"","hide-footer":""}},[a("modalareaEditar")],1),a("b-table",{attrs:{bordered:"","show-empty":"",small:"","head-variant":"light",items:t.items,fields:t.fields},scopedSlots:t._u([{key:"cell(editar)",fn:function(e){return[a("b-button",{staticClass:"mr-1",attrs:{size:"sm"},on:{click:function(a){return t.infoa(e.item,e.index,a.target)}}},[t._v("\n        Editar\n      ")])]}}])})],1)},it=[],lt=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t.show?a("b-form",{on:{submit:t.onSubmit}},[a("b-form-group",{attrs:{id:"input-group-1",label:"Área","label-for":"input-1",description:""}},[a("b-form-input",{attrs:{id:"input-1",required:"",placeholder:"Introduce un área"},model:{value:t.form.area,callback:function(e){t.$set(t.form,"area",e)},expression:"form.area"}})],1),a("b-form-group",{attrs:{id:"input-group-2",label:"Descripción:","label-for":"input-2"}},[a("b-form-textarea",{attrs:{id:"input-2",placeholder:"Introduce una descripción",rows:"3","max-rows":"6"},model:{value:t.form.descripcion,callback:function(e){t.$set(t.form,"descripcion",e)},expression:"form.descripcion"}})],1),a("b-form-checkbox",{attrs:{id:"checkbox-1",name:"checkbox-1",value:"accepted","unchecked-value":"not_accepted"},model:{value:t.form.checaEstatus,callback:function(e){t.$set(t.form,"checaEstatus",e)},expression:"form.checaEstatus"}},[t._v("\n      Activo\n    ")]),a("p"),a("b-container",{staticClass:"bv-example-row"},[a("b-row",[a("b-col",{attrs:{cols:"6"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{attrs:{type:"submit",variant:"success"}},[t._v("Guardar")])],1),a("b-col",{attrs:{cols:"1"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{on:{click:function(e){return t.$bvModal.hide("modal-2")}}},[t._v("Cancelar")])],1)],1)],1)],1):t._e()],1)},ct=[],ut={data:function(){return{form:{area:"",descripcion:"",checaEstatus:[]},show:!0}},methods:{onSubmit:function(t){t.preventDefault(),this.showConfirm()},onReset:function(t){var e=this;t.preventDefault(),this.form.area="",this.form.checaEstatus=[],this.show=!1,this.$nextTick((function(){e.show=!0}))},showConfirm:function(){var t=this;this.$bvModal.msgBoxOk("Datos enviados correctamente",{title:"Confirmación",size:"sm",buttonSize:"sm",okVariant:"success",headerClass:"p-2 border-bottom-0",footerClass:"p-2 border-top-0",centered:!0}).then((function(e){t.$bvModal.hide("modal-2")})).catch((function(t){}))}}},dt=ut,mt=Object(l["a"])(dt,lt,ct,!1,null,null,null),ft=mt.exports,bt={components:{modalareaEditar:ft},data:function(){return{items:[{ID:12341,nombre:"Área 1"},{ID:12342,nombre:"Área 2"},{ID:12343,nombre:"Área 3"},{ID:12344,nombre:"Área 4"}],fields:[{key:"ID",label:"ID "},{key:"nombre",label:"Nombre de Área"},{key:"editar",label:"Editar"}],infoModalarea:{id:"modal-2",title:"",content:""}}},methods:{infoa:function(t,e,a){this.infoModalarea.title="Row index: ".concat(e),this.infoModalarea.content=JSON.stringify(t,null,2),this.$root.$emit("bv::show::modal",this.infoModalarea.id,a)}}},pt=bt,ht=Object(l["a"])(pt,st,it,!1,null,null,null),vt=ht.exports,xt=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t.show?a("b-form",{on:{submit:t.onSubmit,reset:t.onReset}},[a("b-input-group",{staticClass:"mt-3",attrs:{prepend:"Buscar por ID"}},[a("b-form-input"),a("b-input-group-append",[a("b-button",{attrs:{variant:"success"}},[t._v("Buscar")])],1)],1),a("p"),a("b-card",{staticClass:"text-center",attrs:{"bg-variant":"light",header:"Resultado de Búsqueda"}},[a("b-card-text",[a("b-table",{attrs:{fixed:"",small:"",items:t.items,"thead-class":"hidden_header"}})],1)],1),a("p"),a("b-form-group",{attrs:{id:"input-group-3",label:"Area:","label-for":"input-3"}},[a("b-form-select",{attrs:{id:"input-3",options:t.area,required:""},model:{value:t.form.area,callback:function(e){t.$set(t.form,"area",e)},expression:"form.area"}})],1),a("b-form-group",{attrs:{id:"input-group-4",label:"Perfil:","label-for":"input-4"}},[a("b-form-select",{attrs:{id:"input-4",options:t.perfil,required:""},model:{value:t.form.perfil,callback:function(e){t.$set(t.form,"perfil",e)},expression:"form.perfil"}})],1),a("p"),a("b-container",{staticClass:"bv-example-row"},[a("b-row",[a("b-col",{attrs:{cols:"6"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{attrs:{type:"submit",variant:"success"}},[t._v("Guardar")])],1),a("b-col",{attrs:{cols:"1"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{on:{click:function(e){return t.$bvModal.hide("modal-usr-alta")}}},[t._v("Cancelar")])],1)],1)],1)],1):t._e()],1)},gt=[],wt={data:function(){return{form:{area:null,perfil:null},area:[{text:"Seleccionar Área",value:null},"Area 1","Area 2","Area 3","Area 4"],perfil:[{text:"Seleccionar Perfil",value:null},"Perfil 1","Perfil 2","Perfil 3","Perfil 4"],show:!0,items:[{campo:"ID",valor:"12345"},{campo:"Nombre",valor:"Larsen"},{campo:"Apellido Paterno",valor:"Geneva"},{campo:"Apellido Materno",valor:"Jami"},{campo:"Correo Electrónico",valor:"correo@correo.com"}]}},methods:{onSubmit:function(t){t.preventDefault(),this.$bvModal.hide("modal-usr-alta")},onReset:function(t){var e=this;t.preventDefault(),this.show=!1,this.$nextTick((function(){e.show=!0}))}}},Ct=wt,_t=(a("2165"),Object(l["a"])(Ct,xt,gt,!1,null,null,null)),Et=_t.exports,kt=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t.show?a("b-form",{on:{submit:t.onSubmit}},[a("b-form-group",{attrs:{id:"input-group-1",label:"Área","label-for":"input-1",description:""}},[a("b-form-input",{attrs:{id:"input-1",required:"",placeholder:"Introduce un área"},model:{value:t.form.area,callback:function(e){t.$set(t.form,"area",e)},expression:"form.area"}})],1),a("b-form-group",{attrs:{id:"input-group-2",label:"Descripción:","label-for":"input-2"}},[a("b-form-textarea",{attrs:{id:"textarea",placeholder:"Introduce una descripción",rows:"3","max-rows":"6"},model:{value:t.form.descripcion,callback:function(e){t.$set(t.form,"descripcion",e)},expression:"form.descripcion"}})],1),a("p"),a("b-container",{staticClass:"bv-example-row"},[a("b-row",[a("b-col",{attrs:{cols:"6"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{attrs:{type:"submit",variant:"success"}},[t._v("Guardar")])],1),a("b-col",{attrs:{cols:"1"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{on:{click:function(e){return t.$bvModal.hide("modal-area-alta")}}},[t._v("Cancelar")])],1)],1)],1)],1):t._e()],1)},$t=[],At={data:function(){return{form:{area:"",descripcion:""},show:!0}},methods:{onSubmit:function(t){t.preventDefault(),this.$bvModal.hide("modal-area-alta")},onReset:function(t){var e=this;t.preventDefault(),this.form.email="",this.form.name="",this.form.food=null,this.form.checked=[],this.show=!1,this.$nextTick((function(){e.show=!0}))}}},yt=At,Dt=Object(l["a"])(yt,kt,$t,!1,null,null,null),St=Dt.exports,Ot=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-modal",{attrs:{id:t.infoModalperfil.id,title:"EDITAR PERFIL","ok-only":"","hide-footer":""}},[a("perfil")],1),a("b-table",{attrs:{bordered:"","show-empty":"",small:"","head-variant":"light",items:t.items,fields:t.fields},scopedSlots:t._u([{key:"cell(editar)",fn:function(e){return[a("b-button",{staticClass:"mr-1",attrs:{size:"sm"},on:{click:function(a){return t.infoa(e.item,e.index,a.target)}}},[t._v("\n        Editar\n      ")])]}}])})],1)},Rt=[],Mt=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t.show?a("b-form",{on:{submit:t.onSubmit}},[a("b-form-group",{attrs:{id:"input-group-1",label:"Perfil","label-for":"input-1",description:""}},[a("b-form-input",{attrs:{id:"input-1",required:"",placeholder:"Introduce un Perfil"},model:{value:t.form.perfil,callback:function(e){t.$set(t.form,"perfil",e)},expression:"form.perfil"}})],1),a("b-form-checkbox",{attrs:{id:"checkbox-1",name:"checkbox-1",value:"accepted","unchecked-value":"not_accepted"},model:{value:t.form.checaEstatus,callback:function(e){t.$set(t.form,"checaEstatus",e)},expression:"form.checaEstatus"}},[t._v("\n      Activo\n    ")]),a("p"),a("b-container",{staticClass:"bv-example-row"},[a("b-row",[a("b-col",{attrs:{cols:"6"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{attrs:{type:"submit",variant:"success"}},[t._v("Guardar")])],1),a("b-col",{attrs:{cols:"1"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{on:{click:function(e){return t.$bvModal.hide("info-modal4")}}},[t._v("Cancelar")])],1)],1)],1)],1):t._e()],1)},Pt=[],It={data:function(){return{form:{perfil:"",checaEstatus:[]},show:!0}},methods:{onSubmit:function(t){t.preventDefault(),this.showConfirm()},onReset:function(t){var e=this;t.preventDefault(),this.form.perfil="",this.form.checaEstatus=[],this.show=!1,this.$nextTick((function(){e.show=!0}))},showConfirm:function(){var t=this;this.$bvModal.msgBoxOk("Datos enviados correctamente",{title:"Confirmación",size:"sm",buttonSize:"sm",okVariant:"success",headerClass:"p-2 border-bottom-0",footerClass:"p-2 border-top-0",centered:!0}).then((function(e){t.$bvModal.hide("info-modal4")})).catch((function(t){}))}}},jt=It,Tt=Object(l["a"])(jt,Mt,Pt,!1,null,null,null),zt=Tt.exports,Nt={components:{perfil:zt},data:function(){return{items:[{ID:12341,nombre:"PERFIL 1"},{ID:12342,nombre:"PERFIL 2"},{ID:12343,nombre:"PERFIL 3"},{ID:12344,nombre:"PERFIL 4"}],fields:[{key:"ID",label:"ID "},{key:"nombre",label:"Nombre de Perfil"},{key:"editar",label:"Editar"}],infoModalperfil:{id:"info-modal4",title:"",content:""}}},methods:{infoa:function(t,e,a){this.infoModalperfil.title="Row index: ".concat(e),this.infoModalperfil.content=JSON.stringify(t,null,2),this.$root.$emit("bv::show::modal",this.infoModalperfil.id,a)}}},Ft=Nt,Ut=Object(l["a"])(Ft,Ot,Rt,!1,null,null,null),Bt=Ut.exports,qt=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t.show?a("b-form",{on:{submit:t.onSubmit}},[a("b-form-group",{attrs:{id:"input-group-1",label:"Perfil","label-for":"input-1",description:""}},[a("b-form-input",{attrs:{id:"input-1",required:"",placeholder:"Introduce un Perfil"},model:{value:t.form.perfil,callback:function(e){t.$set(t.form,"perfil",e)},expression:"form.perfil"}})],1),a("p"),a("b-container",{staticClass:"bv-example-row"},[a("b-row",[a("b-col",{attrs:{cols:"6"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{attrs:{type:"submit",variant:"success"}},[t._v("Guardar")])],1),a("b-col",{attrs:{cols:"1"}}),a("b-col",{attrs:{cols:"2"}},[a("b-button",{on:{click:function(e){return t.$bvModal.hide("modal-perfil-alta")}}},[t._v("Cancelar")])],1)],1)],1)],1):t._e()],1)},Lt=[],Gt={data:function(){return{form:{perfil:""},show:!0}},methods:{onSubmit:function(t){t.preventDefault(),this.$bvModal.hide("modal-perfil-alta")},onReset:function(t){var e=this;t.preventDefault(),this.form.perfil="",this.show=!1,this.$nextTick((function(){e.show=!0}))}}},Jt=Gt,Vt=Object(l["a"])(Jt,qt,Lt,!1,null,null,null),Ht=Vt.exports,Kt={components:{cambioMiPass:D,gridCatUsr:nt,gridCatArea:vt,modalusr:Et,modalarea:St,headerPage:I,gridPerfil:Bt,modalPerfil:Ht},data:function(){return{fields:["campo","valor"],items:{Nombre:"Gustavo A. Arellano",ID:"12345",Perfil:"Administrador"}}},methods:{salir:function(){this.$router.push("/")}}},Qt=Kt,Wt=(a("dcdd"),Object(l["a"])(Qt,V,H,!1,null,null,null)),Xt=Wt.exports,Yt=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("h1",[t._v("Intentos")]),a("b-card",{attrs:{"no-body":""}},[a("b-tabs",{attrs:{card:""}},[a("b-tab",{attrs:{title:"Contexto",active:""}},[a("agregatexto",{attrs:{prepends:t.pre.prepends}}),a("mostrar",{attrs:{items:t.opciones.ContextoData}})],1),a("b-tab",{attrs:{title:"Eventos"}},[a("b-card-text",[a("agregar",{attrs:{opcionesTab:t.opciones.Eventos}}),a("mostrar",{attrs:{items:t.opciones.EventosData}})],1)],1),a("b-tab",{attrs:{title:"Frases"}},[a("b-card-text",[a("agregar",{attrs:{opcionesTab:t.opciones.Frases}}),a("mostrar",{attrs:{items:t.opciones.FraseData}})],1)],1),a("b-tab",{attrs:{title:"Acciones y Parametros"}},[a("b-card-text",[a("agregar",{attrs:{opcionesTab:t.opciones.AccionesP}}),a("mostrar",{attrs:{items:t.opciones.AccionesData}})],1)],1),a("b-tab",{attrs:{title:"Respuestas"}},[a("b-card-text",[a("agregar",{attrs:{opcionesTab:t.opciones.Respuestas}}),a("mostrar",{attrs:{items:t.opciones.RespuestasData}})],1)],1)],1)],1)],1)},Zt=[],te=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-input-group",{key:"",staticClass:"mb-3",attrs:{size:"",prepend:t.opcionesTab}},[a("b-form-input"),a("b-input-group-append",[a("b-button",{attrs:{size:"sm",text:"Button",variant:"success"}},[t._v("Agregar")])],1)],1)],1)},ee=[],ae={props:["opcionesTab"]},re=ae,oe=Object(l["a"])(re,te,ee,!1,null,null,null),ne=oe.exports,se=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-table",{attrs:{bordered:"",small:"",light:"",hover:"","head-variant":"light",items:t.items,fields:t.fields,"select-mode":"single",selectable:""},on:{"row-selected":t.onRowSelected}})],1)},ie=[],le={props:["items"],selected:[],methods:{onRowSelected:function(t){this.selected=t,alert(JSON.stringify(t))}}},ce=le,ue=Object(l["a"])(ce,se,ie,!1,null,null,null),de=ue.exports,me=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-input-group",{staticClass:"mb-2",attrs:{prepend:t.prepends}},[a("b-form-input",{attrs:{"aria-label":"ContextoEntrada"}}),a("b-form-input",{attrs:{"aria-label":"ContextoSalida"}}),a("b-input-group-append",[a("b-button",{attrs:{size:"sm",text:"Button",variant:"success"}},[t._v("Agregar")])],1)],1)],1)},fe=[],be={props:["prepends"]},pe=be,he=Object(l["a"])(pe,me,fe,!1,null,null,null),ve=he.exports,xe={components:{agregar:ne,mostrar:de,agregatexto:ve},data:function(){return{pre:{prepends:"Entrada/Salida"},opciones:{Eventos:"Evento",EventosData:[{Eventos:"Evento 1"},{Eventos:"Evento 2"},{Eventos:"Evento 3"},{Eventos:"Evento 4"}],Frases:"Frase",FraseData:[{Frases:"Frases 1"},{Frases:"Frases 2"},{Frases:"Frases 3"},{Frases:"Frases 4"}],AccionesP:"Acciones",AccionesData:[{Acciones:"Acciones 1"},{Acciones:"Acciones 2"},{Acciones:"Acciones 3"},{Acciones:"Acciones 4"}],Respuestas:"Respuestas",RespuestasData:[{Respuestas:"Respuestas 1"},{Respuestas:"Respuestas 2"},{Respuestas:"Respuestas 3"},{Respuestas:"Respuestas 4"}],Contexto:"Contexto",ContextoData:[{ContextoEntrada:"Contexto 1",ContextoSalida:"Contexto 1"},{ContextoEntrada:"Contexto 2",ContextoSalida:"Contexto 1"},{ContextoEntrada:"Contexto 3",ContextoSalida:"Contexto 1"},{ContextoEntrada:"Contexto 4",ContextoSalida:"Contexto 1"}]}}}},ge=xe,we=Object(l["a"])(ge,Yt,Zt,!1,null,null,null),Ce=we.exports,_e=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("h1",[t._v("Entidades")]),a("checks",{attrs:{options:t.options}}),a("context",{attrs:{prepend:t.pre.prepends}})],1)},Ee=[],ke=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-form-group",{attrs:{label:""}},[a("b-form-checkbox-group",{attrs:{id:"checkbox-group-1",options:t.options,name:"flavour-1"},model:{value:t.selected,callback:function(e){t.selected=e},expression:"selected"}})],1)],1)},$e=[],Ae={props:["options"]},ye=Ae,De=Object(l["a"])(ye,ke,$e,!1,null,null,null),Se=De.exports,Oe={components:{checks:Se,context:ve},data:function(){return{selected:[],pre:{prepends:"Entrada/Salida"},options:[{text:"Define Synonyms",value:"1"},{text:"Regexp entity",value:"2"},{text:"Allow automated expansion",value:"3"},{text:"Fuzzy matching",value:"4"}]}}},Re=Oe,Me=Object(l["a"])(Re,_e,Ee,!1,null,null,null),Pe=Me.exports,Ie=[{path:"",component:w,name:"login"},{path:"/masterUsr",component:J,name:"masterUsr",children:[{path:"intents",component:Ce},{path:"entities",component:Pe}]},{path:"/masterAdm",component:Xt}],je=a("bc3a"),Te=a.n(je),ze=a("a7fe"),Ne=a.n(ze),Fe=a("0665"),Ue=a.n(Fe),Be=a("90ea"),qe=a.n(Be);Te.a.defaults.baseURL="http://localhost:9090",r["default"].config.productionTip=!1,r["default"].use(Ue.a),r["default"].use(b["a"]),r["default"].use(Ne.a,Te.a),r["default"].use(f["a"]),r["default"].use(qe.a);var Le=new b["a"]({routes:Ie,mode:"history"});new r["default"]({store:m,router:Le,render:function(t){return t(u)}}).$mount("#app")},"5c0b":function(t,e,a){"use strict";var r=a("e332"),o=a.n(r);o.a},"728f":function(t,e,a){"use strict";var r=a("95b9"),o=a.n(r);o.a},"7eea":function(t,e,a){"use strict";var r=a("04d8"),o=a.n(r);o.a},"8a0b":function(t,e,a){t.exports=a.p+"img/impi_logo.42006171.png"},"95b9":function(t,e,a){},a3c8:function(t,e,a){},c032:function(t,e){},c348:function(t,e,a){"use strict";var r=a("e5dc"),o=a("3ef2"),n=a("2877"),s=Object(n["a"])(o["default"],r["a"],r["b"],!1,null,null,null);e["default"]=s.exports},dcdd:function(t,e,a){"use strict";var r=a("2a74"),o=a.n(r);o.a},e332:function(t,e,a){},e5dc:function(t,e,a){"use strict";var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-navbar",{attrs:{toggleable:"lg",type:"dark",variant:"dark"}},[a("div",[a("b-dropdown",{staticClass:"m-2",attrs:{id:"dropdown-offset","split-variant":"outline-light",variant:"light",text:"Menú"}},[a("b-dropdown-item",{attrs:{href:"/masterUsr/intents"}},[t._v("Intentos")]),a("b-dropdown-item",{attrs:{href:"/masterUsr/entities"}},[t._v("Entidades")])],1)],1),a("b-collapse",{attrs:{id:"nav-collapse","is-nav":""}},[a("b-navbar-nav",{staticClass:"ml-auto"},[a("b-nav-form",[a("b-form-input",{staticClass:"mr-sm-2",attrs:{size:"sm",placeholder:"..."}}),a("b-button",{staticClass:"my-2 my-sm-0",attrs:{size:"sm",type:"submit"}},[t._v("Buscar")])],1)],1)],1)],1)],1)},o=[];a.d(e,"a",(function(){return r})),a.d(e,"b",(function(){return o}))}});
//# sourceMappingURL=app.d8cccd56.js.map