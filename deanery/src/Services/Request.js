const Request = {
  getStudents() {
    return fetch("http://localhost:8080/student/show/all").then(res => res.json());
  },

  getStudentsOnGroup(group) {
    return fetch("http://localhost:8080/student/show/group/" + group).then(res => res.json());
  }
};

export default Request
