<template>
    <div>      
      <b-modal :id="infoModal.id" title="EDITAR USUARIO" ok-only @hide="resetInfoModal" hide-footer>
      <modalUsrEditar></modalUsrEditar>
      <pre>{{ infoModal.content }}</pre>
    </b-modal>
      <b-container fluid>
        <b-table striped hover 
        show-empty
        small        
        :items="items"
        :fields="fields"
         >
       <template v-slot:cell(editar)="row">
        <b-button size="sm" @click="info(row.item, row.index, $event.target)" class="mr-1">
          Editar
        </b-button>       
      </template>
      <template v-slot:cell(enviarliga)="row">
        <a :href="`#liga`">Enviar</a>      
      </template>         
        </b-table>       
      </b-container>
    </div>    
</template>
<script>
 import modalUsrEditar from './modalUsrEditar'
export default { 
   components:{
     modalUsrEditar
   },
    data() {
      return {
        items: [
          { ID: 12341,nombre: 'Nombre 1',area:'Area 1', CORREO: 'correo1@correo.com' },
          { ID: 12342,nombre: 'Nombre 2',area:'Area 2', CORREO: 'correo2@correo.com' },
          { ID: 12343,nombre: 'Nombre 3',area:'Area 3', CORREO: 'correo3@correo.com' },
          { ID: 12344,nombre: 'Nombre 4',area:'Area 4', CORREO: 'correo4@correo.com' }          
        ],   
         fields: [
            { key: 'ID', label: 'ID ' },
            { key: 'nombre', label: 'Nombre' },
            { key: 'area', label: 'Area' },
            { key: 'CORREO', label: 'Correo Electrónico' },
            { key: 'editar', label: 'Editar' },
            { key: 'enviarliga', label: 'Enviar Liga' }
         ],
         infoModal: {
          id: 'info-modal1',
          title: '',
          content: ''
        }
      }
    },
     methods: {
     info(item, index, button) {
        this.infoModal.title = `Row index: ${index}`
        this.infoModal.content = JSON.stringify(item, null, 2)
        this.$root.$emit('bv::show::modal', this.infoModal.id, button)
      }
     }
  }
</script>