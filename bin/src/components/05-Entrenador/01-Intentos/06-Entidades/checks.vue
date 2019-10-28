<template>
<div>
    <b-form-group label="">
      <b-form-checkbox-group
        id="checkbox-group-1"
        v-model="selected"
        :options="options"
        name="flavour-1"
      ></b-form-checkbox-group>
    </b-form-group>
</div>
</template>
<script>
export default {
    props:['options']
}
</script>   
