const Request = {
  getStudents() {
    return fetch("http://localhost:8080/student/show/all").then(res => res.json());
  },

  getStudentsOnGroup(group) {
    return fetch("http://localhost:8080/student/show/group/" + group).then(res => res.json());
  },

  getTypeAndGroup(){
    return fetch("http://localhost:8080/subject/type/show").then(res => res.json());
  },

  getWholeJournal(){
    return fetch("http://localhost:8080/journal/whole").then(res => res.json());
  },

  getAllGroup(){
    return fetch("http://localhost:8080/group/show/all").then(res => res.json());
  }
};

export default Request
