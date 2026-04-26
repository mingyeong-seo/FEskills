const btn = document.getElementById('btn');

btn.addEventListener('click', () => {
  console.log('클릭됨');
  console.log('안녕');
  console.log('123');
});

const btn2 = document.getElementById('btn2');
const text = document.getElementById('text');

btn2.addEventListener('click', () => {
  text.textContent = '바뀜';
});

const content = document.getElementById('content');
const enter = document.getElementById('enter');

enter.addEventListener('click', () => {
  text.textContent = content.value;
});

content.addEventListener('keydown', (e) => {
  if (e.key === 'Enter') {
    text.textContent = content.value;
    content.value = '';
  }
});

const testContent = document.getElementById('testContent');
const testEnter = document.getElementById('testEnter');
const list = document.getElementById('list');

// 등록하는건 중복이다. 함수로 만들자.
function addItem() {
  const li = document.createElement('li');
  li.textContent = testContent.value;
  list.appendChild(li);
  testContent.value = '';
}

// 클릭
testEnter.addEventListener('click', addItem);

// 엔터
testContent.addEventListener('keydown', (e) => {
  if (e.key === 'Enter') {
    addItem();
  }
});
