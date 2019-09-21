<template>
    <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">      
      <b-table fixed small :items="items" thead-class="hidden_header"></b-table>        
      <b-form-group id="input-group-3" label="Area:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="form.area"
          :options="areas"
          required
        ></b-form-select>
      </b-form-group> 
      <p></p>
      <b-container class="bv-example-row">
        <b-row>
            <b-col cols="6"></b-col>
            <b-col cols="2">
                <b-button type="submit" variant="success">Actualizar</b-button>                
            </b-col>
            <b-col cols="1">
            </b-col>
            <b-col cols="2">
                <b-button @click="$bvModal.hide('info-modal1')">Cancelar</b-button>
            </b-col>
        </b-row>        
      </b-container>
    </b-form>   
    </div>
</template>
<script>
export default {
    data() {
      return {
        form: {
          contra1: '',
          contra2: '',
           area: null,
        }, 
        areas: [{ text: 'Seleccionar Área', value: null }, 'Area 1', 'Area 2', 'Area 3', 'Area 4'],       
        show: true,
        items: [
          { campo: 'ID', valor: '12345' },
          { campo: 'Nombre', valor: 'Larsen' },
          { campo: 'Apellido Paterno', valor: 'Geneva' },
          { campo: 'Apellido Materno', valor: 'Jami' },
          { campo: 'Correo Electrónico', valor: 'correo@correo.com' }
        ]
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        alert(JSON.stringify(this.form))
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.form.contra1 = ''
        this.form.contra2 = ''       
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    }
  }
</script>
<style>
.hidden_header {
  display: none;
}
</style>