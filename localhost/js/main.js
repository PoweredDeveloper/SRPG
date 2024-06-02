var isopenpw = false;
document.getElementById('pwin').style.display = 'none';

function profilewind() {
    if (isopenpw == false) {
        document.getElementById('pwin').style.display = 'block';
        isopenpw = true;
    } else {
        document.getElementById('pwin').style.display = 'none';
        isopenpw = false;
    }
}

function profilesel(el) {
    if (el.innerHTML == "Главная") {
        document.getElementById('psmain').style.display = 'block';
        document.getElementById('psacco').style.display = 'none';
        document.getElementById('pspers').style.display = 'none';
        document.getElementById('psfrie').style.display = 'none';
        document.getElementById('psclan').style.display = 'none';
        document.getElementById('psinve').style.display = 'none';
        document.getElementById('psnoti').style.display = 'none';
        document.getElementById('pssett').style.display = 'none';
    } else if (el.innerHTML == "Аккаунт") {
        document.getElementById('psmain').style.display = 'none';
        document.getElementById('psacco').style.display = 'block';
        document.getElementById('pspers').style.display = 'none';
        document.getElementById('psfrie').style.display = 'none';
        document.getElementById('psclan').style.display = 'none';
        document.getElementById('psinve').style.display = 'none';
        document.getElementById('psnoti').style.display = 'none';
        document.getElementById('pssett').style.display = 'none';
    } else if (el.innerHTML == "Персонаж") {
        document.getElementById('psmain').style.display = 'none';
        document.getElementById('psacco').style.display = 'none';
        document.getElementById('pspers').style.display = 'block';
        document.getElementById('psfrie').style.display = 'none';
        document.getElementById('psclan').style.display = 'none';
        document.getElementById('psinve').style.display = 'none';
        document.getElementById('psnoti').style.display = 'none';
        document.getElementById('pssett').style.display = 'none';
    } else if (el.innerHTML == "Друзья") {
        document.getElementById('psmain').style.display = 'none';
        document.getElementById('psacco').style.display = 'none';
        document.getElementById('pspers').style.display = 'none';
        document.getElementById('psfrie').style.display = 'block';
        document.getElementById('psclan').style.display = 'none';
        document.getElementById('psinve').style.display = 'none';
        document.getElementById('psnoti').style.display = 'none';
        document.getElementById('pssett').style.display = 'none';
    } else if (el.innerHTML == "Клан") {
        document.getElementById('psmain').style.display = 'none';
        document.getElementById('psacco').style.display = 'none';
        document.getElementById('pspers').style.display = 'none';
        document.getElementById('psfrie').style.display = 'none';
        document.getElementById('psclan').style.display = 'block';
        document.getElementById('psinve').style.display = 'none';
        document.getElementById('psnoti').style.display = 'none';
        document.getElementById('pssett').style.display = 'none';
    } else if (el.innerHTML == "Инвентарь") {
        document.getElementById('psmain').style.display = 'none';
        document.getElementById('psacco').style.display = 'none';
        document.getElementById('pspers').style.display = 'none';
        document.getElementById('psfrie').style.display = 'none';
        document.getElementById('psclan').style.display = 'none';
        document.getElementById('psinve').style.display = 'block';
        document.getElementById('psnoti').style.display = 'none';
        document.getElementById('pssett').style.display = 'none';
    } else if (el.innerHTML == "Уведомления") {
        document.getElementById('psmain').style.display = 'none';
        document.getElementById('psacco').style.display = 'none';
        document.getElementById('pspers').style.display = 'none';
        document.getElementById('psfrie').style.display = 'none';
        document.getElementById('psclan').style.display = 'none';
        document.getElementById('psinve').style.display = 'none';
        document.getElementById('psnoti').style.display = 'block';
        document.getElementById('pssett').style.display = 'none';
    } else if (el.innerHTML == "Настройки") {
        document.getElementById('psmain').style.display = 'none';
        document.getElementById('psacco').style.display = 'none';
        document.getElementById('pspers').style.display = 'none';
        document.getElementById('psfrie').style.display = 'none';
        document.getElementById('psclan').style.display = 'none';
        document.getElementById('psinve').style.display = 'none';
        document.getElementById('psnoti').style.display = 'none';
        document.getElementById('pssett').style.display = 'block';
    }
    document.getElementById('aqa').style.textDecoration = 'none';
    el.style.textDecoration = 'underline';
}
