set nocompatible
set tabstop=2
set shiftwidth=2
set nu
set ru
set autoindent
set smartindent
set cindent
set nobackup
set noswapfile
set ignorecase
set enc=utf-8
set fencs=utf-8,gb2312,gbk
set encoding=utf-8

if has("win32")
	"windows platform
	set guifont=Monospace:h14
	colorscheme torte
else
	" distinguish vim and gvim
	if has('gui_running')
		"gvim
		set guifont=Courier\ 10\ Pitch\ 12	
		"colorscheme desert
		"colorscheme welpe
		"colorscheme ego
		colorscheme mod8
	else
		"vim
		set guifont=Courier\ New\ 14
		colorscheme torte
	endif
endif

"set guioptions-=m
"set guioptions-=T
"set guioptions-=L
"set guioptions-=1
"set cot-=preview
"set cot=menu
syntax on
filetype plugin indent on


" automated add comment
"autocmd BufNewFile *.java exec ":call SetTitle()"
"func SetTitle()
"	if expand("%:e") == 'java'
"		call setline(1, "/*****************************")
"		call setline(2, "\ @Author: samy")
"		call setline(3, "\ @Created Time: ".strftime("%c"))
"		call setline(4, "")
"		call setline(5, "")
"		call setline(6, "")
"		call setline(7, "*****************************/")
"	endif
"endfunc
