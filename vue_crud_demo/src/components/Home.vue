<template>
  <div class="home">
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel" style="margin: 0 auto">Update Student</h4>
          </div>
          <div class="modal-body">
            <div class="panel-body form-inline">
              <label>
                Name:
                <input type="text" class="form-control" v-model="name">
              </label>
            </div>
            <div class="panel-body form-inline">
              <label>
                Sex:
                <input type="radio" id="male" value="male" class="custom-radio" v-model="sex"> Male
                <input type="radio" id="female" value="female" class="custom-radio" v-model="sex"> Female
              </label>
            </div>
            <div class="panel-body form-inline">
              <label>
                Phone:
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
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">close</button>
            <button type="button" class="btn btn-primary" @click="update">update</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div>
    <div class="tab-pane">
      <div class="panel-heading">
        <h3 class="panel-title">Student List</h3>
      </div>
      <div class="form-inline">
        <label>
          Search:
          <input type="text" class="form-control" v-model="keywords">
          <input type="button" class="btn btn-primary" value="Search" @click="getStudents()">
        </label>
      </div>
    </div>
      <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Sex</th>
          <th>Birthday</th>
          <th>Phone number</th>
          <th>Email</th>
          <th>Operation</th>
        </tr>
        </thead>
        <tbody>
<!--        <tr v-for="item in getStudents(keywords)" :key="item.studentId">-->
        <tr v-for="item in students" :key="item.studentId">
          <td>{{item.studentId}}</td>
          <td>{{item.studentName}}</td>
          <td>{{item.studentSex}}</td>
          <!-- 使用过滤器格式化时间 -->
          <td>{{item.studentBirthday | SimpleDateFormat}}</td>
          <td>{{item.studentPhoneNumber}}</td>
          <td>{{item.studentEmail}}</td>
          <td>
            <a href="" data-toggle="modal" data-target="#myModal" @click="fillModal(item)" style="margin-right: 10px">update</a>
            <a href="" @click.prevent="del(item.studentId)"><font color="red">delete</font></a>
          </td>
        </tr>
        </tbody>
      </table>
    <router-link to="/add">Add</router-link>
  </div>
</template>

<script>

// 引入查询函数
import {del, select} from "../api/student";
import { SimpleDateFormat } from "../util/filter";
import {checkDateFormat, checkEmailFormat, checkPhoneNumberFormat} from "../util/checkFormat";
import {update} from "../api/student";

export default {
  name: "Home",
  data() {
    return {
      keywords: "",
      students: this.getStudents(),
      id: '',
      name: '',
      sex: '',
      birthday: '',
      phoneNumber: '',
      email: ''
    }
  },
  methods: {
    getStudents() {
      select(this.keywords).then(res => {
        // console.log(res.data)
        this.students = res.data
        // this.students = res.data
      }).catch(err => {
        console.log(err)
      })
    },
    del(id) {
      del(id).then(res => {
        this.getStudents()
      }).catch(err => {
        console.log(err)
      })
    },
    fillModal(item) {
      this.id = item.studentId
      this.name = item.studentName
      this.sex = item.studentSex
      this.birthday = SimpleDateFormat(item.studentBirthday)
      this.phoneNumber = item.studentPhoneNumber
      this.email = item.studentEmail
    },
    update() {
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
      if(!checkEmailFormat(this.email)) {
        alert("Error: unexpected email format!")
        return
      }
      update(this.id,this.name,this.sex,birthday,this.phoneNumber,this.email)
        .then(res => {
          alert("successful")
          this.getStudents()
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>

<style scoped>
label{
  margin: 0 auto;
}
input{
  margin-left: 10px;
}
div{
  padding: 10px;
}
</style>
