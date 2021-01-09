from flask import Flask, jsonify, request
from tasks_list import tasks

app = Flask(__name__)


@app.route("/")
def home():
    return jsonify({"Mensagem": "Bem vindo(a) ao ToDo List API!"})


@app.route("/tarefas")
def get_tasks_list():
    return jsonify({"Mensagem": "Minha lista de tarefas", "Tarefas": tasks})


@app.route("/tarefas/<int:task_id>")
def get_task_id(task_id):
    task_found = [task for task in tasks if task["id"] == task_id]
    if (len(task_found)):
        return jsonify({"Tarefa": task_found[0]})
    return jsonify({"Mensagem": "Tarefa nao encontrada"})


@app.route("/tarefas/<string:task_status>")
def get_tasks_status(task_status):
    tasks_found = [task for task in tasks if task["status"] == task_status]
    if (len(tasks_found)):
        return jsonify({"Tarefas": tasks_found})
    return jsonify({"Mensagem": "Status da tarefa nao encontrado"})


@app.route("/tarefas", methods=["POST"])
def add_task():
    new_task = {
        "id": request.json["id"],
        "descricao": request.json["descricao"],
        "status": request.json["status"]}
    tasks.append(new_task)
    return jsonify({"Mensagem": "Tarefa adicionada", "Tarefas": tasks})


@app.route("/tarefas/<int:task_id>", methods=["PUT"])
def update_task_status(task_id):
    task_found = [task for task in tasks if task["id"] == task_id]
    if(len(task_found)):
        task_found[0]["status"] = request.json["status"]
        return jsonify({"Mensagem": "Status da tarefa atualizado", "Tarefa": task_found[0]})
    return jsonify({"Mensagem": "Tarefa nao encontrada"})


@app.route("/tarefas/<int:task_id>", methods=["DELETE"])
def delete_task(task_id):
    task_found = [task for task in tasks if task["id"] == task_id]
    if(len(task_found)):
        tasks.remove(task_found[0])
        return jsonify({"Mensagem": "Tarefa removida", "Tarefas": tasks})
    return jsonify({"Mensagem": "Tarefa nao encontrada"})


if __name__ == "__main__":
    app.run(debug=True)
