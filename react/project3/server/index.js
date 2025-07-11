const express = require('express');
const cors = require('cors');
const mysql = require('mysql2');

const app = express();
const PORT = 5000;

// 미들웨어
app.use(cors());
app.use(express.json());

// MySQL 연결
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '1234',
    database: 'todo_app',
});

// 연결 확인
db.connect(err => {
    if (err) {
        console.error('MySQL 연결 오류:', err);
        return;
    }
    console.log('MySQL 연결 성공!');
});

// GET 전체 Todo 가져오기
app.get('/todos', (req, res) => {
    db.query('SELECT * FROM todos', (err, results) => {
        if (err) {
            console.error(err);
            res.status(500).send(err);
            return;
        }
        res.json(results);
    });
});

// POST 새로운 Todo 추가
app.post('/todos', (req, res) => {
    const { content, createdDate } = req.body;
    db.query(
        'INSERT INTO todos (content, isDone, createdDate) VALUES (?, ?, ?)',
        [content, false, createdDate],
        (err, result) => {
            if (err) {
                console.error(err);
                res.status(500).send(err);
                return;
            }
            res.json({ id: result.insertId, content, isDone: false, createdDate });
        }
    );
});

// PUT Todo 상태 변경
app.put('/todos/:id', (req, res) => {
    const { isDone } = req.body;
    const { id } = req.params;
    db.query(
        'UPDATE todos SET isDone = ? WHERE id = ?',
        [isDone, id],
        (err) => {
            if (err) {
                console.error(err);
                res.status(500).send(err);
                return;
            }
            res.sendStatus(200);
        }
    );
});

// DELETE Todo 삭제
app.delete('/todos/:id', (req, res) => {
    const { id } = req.params;
    db.query('DELETE FROM todos WHERE id = ?', [id], (err) => {
        if (err) {
            console.error(err);
            res.status(500).send(err);
            return;
        }
        res.sendStatus(200);
    });
});

app.listen(PORT, () => {
    console.log(`서버가 http://localhost:${5000} 에서 실행 중`);
});
