import request from '../util/request'

export function select(keywords) {
  //查询接口
  return request({
    url: "/student/select",
    method: "get",
    params: {
      'keywords':keywords
    }
  })
}

export function insert(name, sex, birthday, phoneNumber, email) {
  return request({
    url: "/student/insert",
    method: "post",
    data: {
      'studentName': name,
      'studentSex': sex,
      'studentBirthday': birthday,
      'studentPhoneNumber': phoneNumber,
      'studentEmail': email
    }
  })
}

export function del(id) {
  return request({
    url: "/student/delete",
    method: "get",
    params: {
      'id': id
    }
  })
}

export function update(id, name, sex, birthday, phoneNumber, email) {
  return request({
    url: "/student/update",
    method: "post",
    data: {
      'studentId': id,
      'studentName': name,
      'studentSex': sex,
      'studentBirthday': birthday,
      'studentPhoneNumber': phoneNumber,
      'studentEmail': email
    }
  })
}
