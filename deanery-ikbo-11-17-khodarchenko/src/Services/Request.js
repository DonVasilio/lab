const Request = {
getStudents() {
return fetch("/getStudents").then(res => res.json);
}
};
export default Request