<template>
<div>
    <b-container class="bv-example-row">
  <b-row class="text-center">
    <b-col cols="4">
      <img src="../../assets/impi_logo.png" width="100%" class="text-left">
    </b-col>
    <b-col cols="4">
    </b-col>
    <b-col cols="4" class="full-right">
      <b-card-group deck>

    <b-card title="" header-tag="header">
      <template v-slot:header>
        <h6 class="mb-0">{{items.Perfil}}</h6>
      </template>
      <b-card-text>
        {{items.ID}}-
        {{items.Nombre}}
      </b-card-text>
    </b-card>
  </b-card-group>
      
    </b-col>
  </b-row>
  </b-container>    
           <p></p>
</div>
</template>
<script>
export default{

props:['items']
     
}
</script>