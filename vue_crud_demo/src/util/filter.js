export function SimpleDateFormat(timeString) {
  //时间格式化  yyyy-MM-dd
  let date = new Date(timeString)
  let year = date.getFullYear()
  let month = date.getMonth()+1
  let day = date.getDate()
  return `${year}-${month}-${day}`
}
