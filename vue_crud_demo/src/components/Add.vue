<template>
  <div class="add">
    <a href="" @click.prevent="returnTo" style="position: absolute;top:20px;left:20px">Return</a>
    <h2 style="vertical-align: center">Add a student</h2>
    <div class="panel-body form-inline">
      <label>
        <font color="red">*</font>Name:
        <input type="text" class="form-control" v-model="name">
      </label>
    </div>
    <div class="panel-body form-inline">
      <label>
        <font color="red">*</font>Sex:
        <input type="radio" id="male" value="male" class="custom-radio" v-model="sex"> Male
        <input type="radio" id="female" value="female" class="custom-radio" v-model="sex"> Female
      </label>
    </div>
    <div class="panel-body form-inline">
      <label>
        <font color="red">*</font>Phone:
        <input type="text" class="form-control" v-model="phoneNumber">
      </label>
    </div>
    <div class="panel-body form-inline">
      <label>
        Birthday:
        <input type="text" class="form-control" v-model="birthday">
      </label>
    </div>
    <div class="panel-body form-inline">
      <label>
        Email:
        <input type="text" class="form-control" v-model="email">
      </label>
    </div>
    <button class="btn btn-primary" value="Add" @click="addTo">Add</button>
  </div>
</template>

<script>

import {insert} from "../api/student";
import {checkDateFormat} from "../util/checkFormat";
import {checkPhoneNumberFormat} from "../util/checkFormat";
import {checkEmailFormat} from "../util/checkFormat";

export default {
  name: "Add",
  data() {
    return {
      name: '',
      sex: '',
      birthday: '',
      phoneNumber: '',
      email: ''
    }
  },
  methods: {
    addTo() {
      //name、sex、phone number不为空
      var para = ''
      if(((para = 'name') && this.name === '') || ((para = 'sex') && this.sex === '') || ((para = 'phone number') && this.phoneNumber === '')) {
        alert("Error: "+ para +" is missing!")
        return;
      }
      //生日
      var birthday = new Date();
      try {
        birthday = checkDateFormat(this.birthday)
      } catch (e){
        alert("Error: unexpected date format!\nValid format:yyyy-MM-dd")
        return
      }
      //检查phone number的格式
      if(!checkPhoneNumberFormat(this.phoneNumber)){
        alert("Error: unexpected phone number format!\nValid format:xxx-xxx-xxxx")
        return
      }
      //检查email的格式
      if(this.email !== '' && !checkEmailFormat(this.email)) {
        alert("Error: unexpected email format!")
        return
      }
      insert(this.name,this.sex,birthday,this.phoneNumber,this.email)
        .then(res => {
          alert("successful!")
          this.$router.push('/')
        })
        .catch(err => {
          console.log(err)
        })
    },
    returnTo() {
      this.$router.push("/")
    }
  }
}
</script>

<style scoped>
label{
  margin: 0 auto;
  padding: 10px;
}
input{
  margin-left: 10px;
}
</style>
