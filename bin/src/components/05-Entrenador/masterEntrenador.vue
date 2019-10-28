<template>
<div>
  <menuEntrena></menuEntrena>
  <router-view></router-view>
  </div>
</template>
<script>
import menuEntrena from './menuEntrenador.vue'

  export default {
    components:{
        menuEntrena
    }
  }
</script>