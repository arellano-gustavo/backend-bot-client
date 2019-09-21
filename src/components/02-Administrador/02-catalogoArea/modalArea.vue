<template>
<div>
<b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
        id="input-group-1"
        label="Área"
        label-for="input-1"
        description=""
      >
        <b-form-input
          id="input-1"
          v-model="form.area"          
          required
          placeholder="Introduce un área"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-2" label="Descripción:" label-for="input-2">
        <b-form-textarea
        id="textarea"
        v-model="form.descripcion"
        placeholder="Introduce una descripción"
        rows="3"
        max-rows="6"
    ></b-form-textarea>
      </b-form-group>

      <p></p>
      <b-container class="bv-example-row">
        <b-row>
            <b-col cols="6"></b-col>
            <b-col cols="2">
                <b-button type="submit" variant="success">Guardar</b-button>                
            </b-col>
            <b-col cols="1">
            </b-col>
            <b-col cols="2">
                <b-button @click="$bvModal.hide('modal-3')">Cancelar</b-button>
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
          email: '',
          name: '',
          food: null,
          checked: []
        },
        foods: [{ text: 'Select One', value: null }, 'Carrots', 'Beans', 'Tomatoes', 'Corn'],
        show: true
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
        this.form.email = ''
        this.form.name = ''
        this.form.food = null
        this.form.checked = []
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    }
  }
</script>