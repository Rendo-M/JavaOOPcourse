
from tkinter import *

from requests import delete

win = Tk()
win.title('XO Game')

class XO_button:
    bg_color = 'PeachPuff3'
    width = 5
    height = 2
    fg_color = 'red'
    active = 'enabled' 
    font = ('Arial', 18, 'bold')
    parent = None
    text = ' '

    def Change_color(self, color):
        self.fg_color = color

    def __init__(self, x, y, field, text=' '):
        self.x = x
        self.y = y
        self.parent = field
        self.text=text
        self.btn_obj = Button(text=self.text, height=self.height, width=self.width, fg=self.fg_color, bg=self.bg_color, command=self.human_move, font=self.font)
        self.btn_obj.grid(row=x, column=y)

    def refresh(self):
        self.btn_obj.config(text=self.text, height=self.height, width=self.width, fg=self.fg_color, bg=self.bg_color, command=self.human_move, font=self.font, state=self.active)


    def comp_move(self):
        if self.active:    
            self.text = 'O'
            self.active = 'disabled'
            if self.parent.is_finished():
                
                self.parent.lab.configure(text='O wins!')   
                self.parent.block_all()
            self.refresh();
        
    def reset(self):
           self.bg_color = 'PeachPuff3'
           self.width = 5
           self.height = 2
           self.fg_color = 'red'
           self.active = 'active' 
           self.font = ('Arial', 18, 'bold')
           self.text =''
           self.refresh()


    def human_move(self):
        if self.active:
            self.text = 'X'
            self.active = 'disabled'
            self.refresh()
            if self.parent.is_finished():
                
                self.parent.lab.configure(text='X wins!')    
                self.parent.block_all()
            else:
                self.parent.ai_move()                
            return True
        else:
            return False


   


class Game_field:
    
    def __init__(self):
        self.buttons = [[XO_button(i, j, self) for i in range(3)] for j in range(3)]
        self.lab = Label(text='Играем', font=("Comic Sans MS", 24, "bold"))
        self.lab.grid(row=3, column=0, columnspan=3)

    def check_row(self, n, player):
        text = ''
        pos = -1
        for i in range(3):
            text += self.buttons[n][i].text
        if text.count(player) == 2:
            return text.find(' ')
        return -1            

    def check_col(self, n, player):
        text = ''
        for i in range(3):
            text += self.buttons[i][n].text
        if text.count(player) == 2:
            return text.find(' ')
        return -1            


    def check_diag1(self, player):
        text = ''
        for i in range(3):
            text += self.buttons[i][i].text
        if text.count(player) == 2:
            return text.find(' ')
        return -1            


    def check_diag2(self, player):
        text = ''
        for i in range(3):
            text += self.buttons[i][2-i].text
        if text.count(player) == 2:
            return text.find(' ')
        return -1            

    def can_win(self):
        for i in range(3):
            pos = self.check_row(i, 'O')
            
            if pos > 0:
                return(i, pos)
            pos = self.check_col(i, 'O')
        
            if pos > 0:
                return(pos, i)
            pos = self.check_diag1('O')
            if pos > 0:
                return (pos, pos)
            pos = self.check_diag2('O')
            if pos > 0:
                return (pos, 2-pos)
        return None

    def can_loose(self):
        for i in range(3):
            pos = self.check_row(i, 'X')
            if pos > 0:
                return(i, pos)
            pos = self.check_col(i, 'X')
            if pos > 0:
                return(pos, i)
            pos = self.check_diag1('X')
            if pos > 0:
                return (pos, pos)
            pos = self.check_diag2('X')
            if pos > 0:
                return (pos, 2-pos)    
        return None

    def make_move(self):
        if self.buttons[1][1].text == ' ':
            return (1, 1)
        else: 
            for i in range(0,3,2):
                for j in range(0,3,2):
                    if self.buttons[i][j].text==' ':
                        return (i, j)
            for i in range(3):
                for j in range(3):
                    if self.buttons[i][j].text==' ':
                        return (i, j)                                        
        


    def ai_move(self):
        move = self.can_win()
        if move is None:
            move = self.can_loose()
        if move is None:
            move = self.make_move()  
        if move is not None:             
            self.buttons[move[0]][move[1]].comp_move()
        else:
            self.lab.configure(text='Ничья!')              

    def is_finished(self):
        o_fin1 = o_fin2 = x_fin1 = x_fin2 = True
        
        for i in range(3):
            for j in 'XO':
                fin = len(list(filter(lambda x: x.text==j , self.buttons[i]))) == 3    
                fin = fin or len(list(filter(lambda x: x[i].text==j , self.buttons))) == 3  
                if fin:
                  return fin
            x_fin1 = x_fin1 and self.buttons[i][i].text=='X'
            x_fin2 =  x_fin2 and self.buttons[i][2-i].text=='X' 
            o_fin1 = o_fin1 and self.buttons[i][i].text=='O'
            o_fin2 = o_fin2 and self.buttons[i][2-i].text=='O'     
        f = x_fin1 or x_fin2 or o_fin1 or o_fin2
             
        return f
        
    def block_all(self):
        for j in range(3):
            for i in range(3):
                self.buttons[i][j].active='disabled'
                self.buttons[i][j].refresh()


game = Game_field()

win.mainloop()