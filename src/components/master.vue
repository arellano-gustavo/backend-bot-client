<template>
    <div>
      <b-container class="bv-example-row">
        <b-row>
          <b-col></b-col>
          <b-col></b-col>
          <b-col>
            <b-table Borderless small Fixed  :items="items" :fields="fields" thead-class="hidden_header"></b-table>
          </b-col>
        </b-row>   
      </b-container>    
    <b-card no-body>
    <b-tabs pills card vertical>
      <b-tab title="Entrenar Bot" active>
        <b-card-text>       
        </b-card-text>
      </b-tab>
      <b-tab title="Cambiar Mi Contraseña">
        <b-card-text>Contenido</b-card-text>
      </b-tab>
      <b-tab title="Salir del Sistema">
        <b-card-text>Salir del Sistema</b-card-text>
      </b-tab> 
    </b-tabs>
  </b-card>
</div>
</template>
<script>

export default {
    components:{
   
    },
     data() {
      return {
        // Note `isActive` is left out and will not appear in the rendered table
        fields: ['campo', 'valor'],
        items: [
          { campo: 'Usuario Firmado:', valor: 'Gustavo A. Arellano' },
          { campo: 'ID:', valor: '12345' },
          { campo: 'Rol:', valor: 'Entrenador' }          
        ]
      }
    }
}
</script>
<style>
.hidden_header {
  display: none;
}
</style>